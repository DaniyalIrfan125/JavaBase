package com.danial.javabase.data.remote;


/**
 * Keep all the service related constants here.
 * Author: Daniyal Irfan
 * Email: daniyal@techbayportal.com
 */
public class ApiConstants {
    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    public static final long CONNECT_TIMEOUT = 1;
    public static final long READ_TIMEOUT = 1;
    public static final long WRITE_TIMEOUT = 1;
    static final String API_KEY = "Put your api key here";

    private ApiConstants(){
        // Private constructor to hide the implicit one
    }


}
