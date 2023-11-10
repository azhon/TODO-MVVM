package com.azhon.basic.utils;

import android.text.TextUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * createDate: 2023/11/9 on 11:40
 * desc: 泛型类获取
 *
 * @author azhon
 */


public class GenericsUtil {

    public static Type get(Class<?> cls, String keyword) {
        Type type = cls.getGenericSuperclass();
        Type[] types = ((ParameterizedType) type).getActualTypeArguments();
        if (TextUtils.isEmpty(keyword)) {
            return types[0];
        }
        for (Type t : types) {
            if (t.toString().contains(keyword)) {
                return t;
            }
        }
        return null;
    }
}
