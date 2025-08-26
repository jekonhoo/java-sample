package com.bossien.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EntityUtils {
    public static <T> void setValue(
            Object object,
            String methodName,
            T value
    ) {
        Class clazz = object.getClass();
        try {
            Method setMethod = clazz.getMethod(methodName, value.getClass());
            setMethod.invoke(
                    object,
                    value
            );
        } catch (NoSuchMethodException e) {
            return;
        } catch (InvocationTargetException e) {
            return;
        } catch (IllegalAccessException e) {
            return;
        }
    }
}
