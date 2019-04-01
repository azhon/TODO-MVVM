package com.azhon.basic.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;

/**
 * 文件名:    DensityUtil
 * 创建时间:  2018/3/18 on 13:32
 * 描述:     TODO
 *
 * @author 阿钟
 */


public class DensityUtil {

    /**
     * 获取屏幕宽度（像素）
     *
     * @param context 上下文
     * @return px
     */
    public static int getWith(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度（像素）
     *
     * @param context 上下文
     * @return px
     */
    public static int getHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    /**
     * 获取状态栏的高度
     *
     * @param context 上下文
     * @return px
     */
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }

    /**
     * 获取标题栏（ActionBar）的高度
     *
     * @param context 上下文
     * @return px
     */
    public static int getActionBarHeight(Context context) {
        TypedArray values = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.actionBarSize});
        int actionBarHeight = values.getDimensionPixelSize(0, 0);
        values.recycle();
        return actionBarHeight;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
