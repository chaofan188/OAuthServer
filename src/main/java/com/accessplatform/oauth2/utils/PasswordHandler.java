package com.accessplatform.oauth2.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * 
 */
public abstract class PasswordHandler 
{


    /**
     * Private constructor
     */
    private PasswordHandler() 
    {
    }

    /**
     * md5º”√‹
     *
     * @param originalPassword Original password
     * @return Encrypted password
     */
    public static String encryptPassword(String originalPassword) 
    {
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        return md5PasswordEncoder.encodePassword(originalPassword, null);
    }


}