package com.accessplatform.oauth2.service;

import com.accessplatform.oauth2.domain.*;;

/**
 *
 */

public interface OauthService 
{

    OauthClientDetails loadOauthClientDetails(String clientId);
}