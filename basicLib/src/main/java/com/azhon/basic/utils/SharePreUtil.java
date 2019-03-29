package com.azhon.basic.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 文件名:    SharePreUtil
 * 创建者:    阿钟
 * 创建时间:  2016/12/12 on 11:58
 * 描述:     SharedPreferences存取工具类
 */

public class SharePreUtil {
    /**
     * 配置文件，文件名
     */
    private static final String SHARE_NAME = "config";

    /**
     * 存字符串
     *
     * @param context 上下文
     * @param key     键
     * @param values  值
     */
    public static void putString(Context context, String key, String values) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, values).apply();
    }


    /**
     * 取字符串
     *
     * @param context 上下文
     * @param key     键
     * @param values  默认值
     * @return 取出的值
     */
    public static String getString(Context context, String key, String values) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, values);
    }


    /**
     * 存布尔值
     *
     * @param context 上下文
     * @param key     键
     * @param values  值
     */
    public static void putBoolean(Context context, String key, boolean values) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, values).apply();
    }

    /**
     * 取布尔值
     *
     * @param context 上下文
     * @param key     键
     * @param values  默认值
     * @return true/false
     */
    public static boolean getBoolean(Context context, String key, boolean values) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, values);
    }

    /**
     * 存int值
     *
     * @param context 上下文
     * @param key     键
     * @param values  值
     */
    public static void putInt(Context context, String key, int values) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(key, values).apply();
    }

    /**
     * 取int值
     *
     * @param context 上下文
     * @param key     键
     * @param values  默认值
     * @return
     */
    public static int getInt(Context context, String key, int values) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, values);
    }

    /**
     * 删除一条字段
     *
     * @param context 上下文
     * @param key     键
     */
    public static void deleShare(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        //单个清理
        sp.edit().remove(key).apply();
    }

    /**
     * 删除全部数据
     *
     * @param context 上下文
     */
    public static void deleShareAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        //全部清理
        sp.edit().clear().apply();
    }

    /**
     * 查看SharedPreferences的内容
     */
    public static String lookSharePre(Context context) {
        try {
            FileInputStream stream = new FileInputStream(new File("/data/data/" +
                    context.getPackageName() + "/shared_prefs", SHARE_NAME + ".xml"));
            BufferedReader bff = new BufferedReader(new InputStreamReader(stream));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = bff.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "未找到当前配置文件！";
    }
}