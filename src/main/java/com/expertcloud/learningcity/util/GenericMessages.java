package com.expertcloud.learningcity.util;

@SuppressWarnings("WeakerAccess")
public class GenericMessages {

    private GenericMessages(){
        throw new IllegalStateException("Util class. It cannot be initialized");
    }

    public static final String COURSE = "Course";
    public static final String LECTURE = "Lecture";
    public static final String USER = "User";

    public static final String ID_CANNOT_BE_NULL = "ID cannot be null";
    public static final String REQUEST_CANNOT_BE_NULL = "Request cannot be null";
    public static final String UNABLE_TO_FIND = "Unable to find";
    public static final String UNABLE_TO_FIND_COUSE = UNABLE_TO_FIND + " " + COURSE;
    public static final String UNABLE_TO_FIND_USER = UNABLE_TO_FIND + " " + USER;
    public static final String UNABLE_TO_FIND_LECTURE = UNABLE_TO_FIND + " " + LECTURE;

}
