package com.accessplatform.oauth2.utils;

import java.util.Date;

/**
 * 
 */
public abstract class DateUtils {


    /**
     * Private constructor
     */
    private DateUtils() {
    }

    public static Date now() {
        return new Date();
    }

}