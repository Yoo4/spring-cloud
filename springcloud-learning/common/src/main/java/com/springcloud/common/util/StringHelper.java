package com.springcloud.common.util;

/**
 * @Auther: James Wang
 * @Data: 2018/1/4 10:37
 */

public class StringHelper {
    public static String getObjectValue(Object object) {
        return object == null?"":object.toString();
    }
}
