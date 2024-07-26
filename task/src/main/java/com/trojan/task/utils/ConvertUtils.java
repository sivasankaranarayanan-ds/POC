package com.trojan.task.utils;

import org.apache.commons.lang3.StringUtils;

public class ConvertUtils {

    public static String longToString(Long value) {
        return value != null ? String.valueOf(value) : "";
    }

    public static Integer stringToInt(String value) {
        return (StringUtils.isEmpty(value) && !StringUtils.isNumeric(value)) ? 0 : Integer.parseInt(value);
    }

    public static String intToString(Integer value) {
        return value != null ? String.valueOf(value) : "";
    }
}
