package com.expertcloud.learningcity.util;

import org.springframework.util.Assert;

import static com.expertcloud.learningcity.util.GenericMessages.ID_CANNOT_BE_NULL;
import static com.expertcloud.learningcity.util.GenericMessages.REQUEST_CANNOT_BE_NULL;

public class Validator {

    public static void idNotNull(Object objectId) {

        Assert.notNull(objectId, ID_CANNOT_BE_NULL);

    }

    public static void requestNotNull(Object objectRequest) {

        Assert.notNull(objectRequest, REQUEST_CANNOT_BE_NULL);

    }

}
