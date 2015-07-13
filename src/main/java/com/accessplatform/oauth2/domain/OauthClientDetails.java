package com.accessplatform.oauth2.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import com.accessplatform.oauth2.utils.*;

@Entity
@Table(name="oauth_client_details")

public class OauthClientDetails implements Serializable 
{
	
    @Temporal(TemporalType.DATE)
    @Column(name="create_time")
    private Date createTime = DateUtils.now();
    
    private boolean archived = false;
    
    @Id
    @Column(name="client_id")
    private String clientId;
    
    @Column(name="resource_ids")
    private String resourceIds;
    
    @Column(name="client_secret")
    private String clientSecret;
    /**
     * Available values: read,write
     */
    private String scope;

    /**
     * grant types include
     * "authorization_code", "password", "assertion", and "refresh_token".
     * Default value is "authorization_code,refresh_token".
     */
    @Column(name="authorized_grant_types")
    private String authorizedGrantTypes = "authorization_code,refresh_token";
    
    @Column(name="web_server_redirect_uri")
    private String webServerRedirectUri;//重定向地址
    
    private String authorities;

    @Column(name="access_token_validity")
    private Integer accessTokenValidity;//访问令牌的有效期

    @Column(name="refresh_token_validity")
    private Integer refreshTokenValidity;

    // optional
    @Column(name="additional_information")
    private String additionalInformation;

    /**
     * The client is trusted or not. If it is trust, will skip approve step
     * default false.
     */
    private boolean trusted = false;

    public OauthClientDetails() 
    {
    }
    public boolean getTrusted() 
    {
        return trusted;
    }
    public void setTrusted(boolean trusted)
    {
    	this.trusted = trusted;
    }

    public Date getCreateTime() 
    {
        return createTime;
    }
    public void setCreateTime(Date createtime)
    {
    	this.createTime = createtime;
    }

    public boolean getArchived() 
    {
        return archived;
    }
    public void setArchived(boolean archived)
    {
    	this.archived = archived;
    }

    public String getClientId() 
    {
        return clientId;
    }
    public void setClientId(String clientid)
    {
    	this.clientId = clientid;
    }

    public String getResourceIds() 
    {
        return resourceIds;
    }
    public void setResourceIds(String resourceids)
    {
    	this.resourceIds = resourceids;
    }

    public String getClientSecret() 
    {
        return clientSecret;
    }
    public void setClientSecret(String clientSecret)
    {
    	this.clientSecret = clientSecret;
    }

    public String getScope() 
    {
        return scope;
    }
    public void setScope(String scope)
    {
    	this.scope = scope;
    }

    public String getAuthorizedGrantTypes() 
    {
        return authorizedGrantTypes;
    }
    public void setAuthorizedGrantTypes(String authorizedGrantTypes)
    {
    	this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() 
    {
        return webServerRedirectUri;
    }
    public void setWebServerRedirectUri(String webServerRedirectUri) 
    {
        this.webServerRedirectUri = webServerRedirectUri;
    }
    

    public String getAuthorities() 
    {
        return authorities;
    }
    public void setAuthorities(String authorities)
    {
    	this.authorities = authorities;
    }

    public Integer getAccessTokenValidity() 
    {
        return accessTokenValidity;
    }
    public void setAccessTokenValidity(Integer accessTokenValidity) 
    {
        this.accessTokenValidity = accessTokenValidity;
    }
    

    public Integer getRefreshTokenValidity() 
    {
        return refreshTokenValidity;
    }
    public void setRefreshTokenValidity(Integer refreshTokenValidity) 
    {
        this.refreshTokenValidity = refreshTokenValidity;
    }
    

    public String getAdditionalInformation() 
    {
        return additionalInformation;
    }
    public void setAdditionalInformation(String additionalInformation) 
    {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("OauthClientDetails");
        sb.append("{createTime=").append(createTime);
        sb.append(", archived=").append(archived);
        sb.append(", clientId='").append(clientId).append('\'');
        sb.append(", resourceIds='").append(resourceIds).append('\'');
        sb.append(", clientSecret='").append(clientSecret).append('\'');
        sb.append(", scope='").append(scope).append('\'');
        sb.append(", authorizedGrantTypes='").append(authorizedGrantTypes).append('\'');
        sb.append(", webServerRedirectUri='").append(webServerRedirectUri).append('\'');
        sb.append(", authorities='").append(authorities).append('\'');
        sb.append(", accessTokenValidity=").append(accessTokenValidity);
        sb.append(", refreshTokenValidity=").append(refreshTokenValidity);
        sb.append(", additionalInformation='").append(additionalInformation).append('\'');
        sb.append(", trusted=").append(trusted);
        sb.append('}');
        return sb.toString();
    }
}
