package com.company.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {

    public static void mapParam2Bean(HttpServletRequest request, Object obj) {

        try {
            BeanUtils.populate(obj, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static Integer parseInt(String numberInStr, Integer defaultVal) {

        try {
            return Integer.parseInt(numberInStr);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }

}
