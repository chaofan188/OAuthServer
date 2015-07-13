package com.accessplatform.oauth2.approval;


import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.Assert;


public class OauthUserApprovalHandler implements UserApprovalHandler, InitializingBean 
{
	private static Log logger = LogFactory.getLog(OauthUserApprovalHandler.class);
	private String approvalParameter = OAuth2Utils.USER_OAUTH_APPROVAL;
	private TokenStore tokenStore;
	//private ClientDetailsService clientDetailsService;	
	private OAuth2RequestFactory requestFactory;
	
	//setter
	public void setApprovalParameter(String approvalParameter) 
	{
		this.approvalParameter = approvalParameter;
	}
	public void setTokenStore(TokenStore tokenStore) 
	{
		this.tokenStore = tokenStore;
	}
	public void setRequestFactory(OAuth2RequestFactory requestFactory)
	{
		this.requestFactory = requestFactory;
	}


    public OauthUserApprovalHandler() 
    {	
    }

	@Override
	public void afterPropertiesSet() throws Exception 
	{
		Assert.state(tokenStore != null, "TokenStore must be provided");
		Assert.state(requestFactory != null, "OAuth2RequestFactory must be provided");	
	}
	
	//要不要PreApproval??
	@Override
    public AuthorizationRequest checkForPreApproval(AuthorizationRequest authorizationRequest, Authentication userAuthentication) 
	{	
		boolean approved = false;
		String clientId = authorizationRequest.getClientId();
		Set<String> scopes = authorizationRequest.getScope();
		
		OAuth2Request storedOAuth2Request = requestFactory.createOAuth2Request(authorizationRequest);
		
		OAuth2Authentication authentication = new OAuth2Authentication(storedOAuth2Request, userAuthentication);
		if (logger.isDebugEnabled()) 
		{
			StringBuilder builder = new StringBuilder("Looking up existing token for ");
			builder.append("client_id=" + clientId);
			builder.append(", scope=" + scopes);
			builder.append(" and username=" + userAuthentication.getName());
			logger.debug(builder.toString());
		}

		OAuth2AccessToken accessToken = tokenStore.getAccessToken(authentication);
		logger.debug("Existing access token=" + accessToken);
		if (accessToken != null && !accessToken.isExpired()) 
		{
			logger.debug("User already approved with token=" + accessToken);
			approved = true;
		}
		else 
		{
			logger.debug("Checking explicit approval");
			approved = userAuthentication.isAuthenticated() && approved;
		}
		
		authorizationRequest.setApproved(approved);
		return authorizationRequest;
	}
 
	//待改进，读取用户所拥有的权限以及客户端请求的权限，根据二者返回
	@Override
	public Map<String, Object> getUserApprovalRequest(AuthorizationRequest authorizationRequest,Authentication userAuthentication) 
	{
		Map<String, Object> model = new HashMap<String, Object>();
		model.putAll(authorizationRequest.getRequestParameters());
		return model;
	}
	
	@Override
	public boolean isApproved(AuthorizationRequest authorizationRequest, Authentication userAuthentication) 
	{
		return authorizationRequest.isApproved();
	}

	@Override
	public AuthorizationRequest updateAfterApproval(AuthorizationRequest authorizationRequest, Authentication userAuthentication) 
	{
		Map<String, String> approvalParameters = authorizationRequest.getApprovalParameters();
		Set<String> scopes = new LinkedHashSet();
		for (Map.Entry<String, String> entry : approvalParameters.entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();
			if (value.equals("true"))
			{
				scopes.add(key);
			}
		}
		authorizationRequest.setScope(scopes);
		String flag = approvalParameters.get(approvalParameter);
		boolean approved = flag != null && flag.toLowerCase().equals("true");
		authorizationRequest.setApproved(approved);
		return authorizationRequest;
	}
    
}
