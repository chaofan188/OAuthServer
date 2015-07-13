package com.accessplatform.oauth2.service.impl;

import java.util.List;

import com.accessplatform.oauth2.domain.*;
import com.accessplatform.oauth2.dao.OauthClientDao;

import com.accessplatform.oauth2.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 */
@Service("oauthService")
public class OauthServiceImpl implements OauthService 
{

    @Autowired
    private OauthClientDao oauthDao;

    @Override
    public OauthClientDetails loadOauthClientDetails(String clientId) 
    {
    	String hql = "select o from OauthClientDetails o where o.clientId=?1";
    	List<OauthClientDetails> oauthClients = oauthDao.find(hql, clientId);
    	return oauthClients.get(0);
    	
    }
}