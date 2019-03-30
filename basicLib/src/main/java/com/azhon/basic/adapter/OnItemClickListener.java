package com.azhon.basic.adapter;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.basic.adapter
 * 文件名:    OnItemClickListener
 * 创建时间:  2019-03-29 on 13:53
 * 描述:     TODO RecyclerView Item 长按、点击事件
 *
 * @author 阿钟
 */

public interface OnItemClickListener<Data> {

    /**
     * Item 点击事件
     *
     * @param data     item的数据
     * @param position item的下标
     */
    void onItemClick(Data data, int position);

    /**
     * Item 长按事件
     *
     * @param data     item的数据
     * @param position item的下标
     */
    boolean onItemLongClick(Data data, int position);

}
