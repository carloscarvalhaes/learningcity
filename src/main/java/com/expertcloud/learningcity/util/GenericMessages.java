package com.expertcloud.learningcity.util;

@SuppressWarnings("WeakerAccess")
public class GenericMessages {

    private GenericMessages(){
        throw new IllegalStateException("Util class. It cannot be initialized");
    }

    public static final String ID_CANNOT_BE_NULL = "ID cannot be null";
    public static final String REQUEST_CANNOT_BE_NULL = "Request cannot be null";

}
