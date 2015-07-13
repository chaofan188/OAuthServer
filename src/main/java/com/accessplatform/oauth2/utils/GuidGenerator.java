package com.accessplatform.oauth2.utils;

import java.util.UUID;

/**
 * 
 */
public abstract class GuidGenerator 
{


    /**
     * private constructor
     */
    private GuidGenerator() 
    {
    }

    public static String generate()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}