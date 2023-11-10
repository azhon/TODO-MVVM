package com.azhon.basic.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * createDate: 2023/11/8 on 17:44
 * desc: 管理所有Activity的实例
 *
 * @author azhon
 */
public class ActivityUtil {

    private static Stack<Activity> stack;
    private static ActivityUtil manager;

    /**
     * 获取实例
     */
    public static synchronized ActivityUtil getInstance() {
        if (manager == null) {
            manager = new ActivityUtil();
            stack = new Stack<>();
        }
        return manager;
    }

    /**
     * 添加Activity
     */
    public synchronized void addActivity(Activity activity) {
        stack.add(activity);
    }

    /**
     * 移除Activity
     */
    public synchronized void removeActivity(Activity activity) {
        stack.remove(activity);
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : stack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                return;
            }
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
            stack.remove(activity);
        }
    }

    /**
     * 是否存在Activity
     */
    public boolean containsActivity(Class<?> cls) {
        for (Activity activity : stack) {
            if (activity.getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (Activity activity : stack) {
            if (activity != null) {
                activity.finish();
            }
        }
        stack.clear();
    }
}
