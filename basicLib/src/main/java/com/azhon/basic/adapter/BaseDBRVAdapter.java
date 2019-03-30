package com.azhon.basic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.basic.adapter
 * 文件名:    BaseDBRVAdapter
 * 创建时间:  2019-03-27 on 16:22
 * 描述:     TODO 结合dataBinding的RecyclerView Adapter
 *
 * @author 阿钟
 */

public abstract class BaseDBRVAdapter<Data, DB extends ViewDataBinding> extends RecyclerView.Adapter<BaseDBRVHolder> {

    private List<Data> data;
    private int itemId;
    protected Context context;
    protected int variableId;
    protected OnItemClickListener<Data> listener;


    public BaseDBRVAdapter(@LayoutRes int itemId, int variableId) {
        this.itemId = itemId;
        this.variableId = variableId;
        data = new ArrayList<>();
    }

    public BaseDBRVAdapter(List<Data> data, @LayoutRes int itemId, int variableId) {
        this.data = data == null ? new ArrayList<Data>() : data;
        this.itemId = itemId;
        this.variableId = variableId;
    }


    @NonNull
    @Override
    public BaseDBRVHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        this.context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        DB binding = DataBindingUtil.inflate(inflater, itemId, parent, false);
        return new BaseDBRVHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BaseDBRVHolder holder, final int position) {
        DB binding = DataBindingUtil.getBinding(holder.itemView);
        final Data itemData = data.get(position);
        binding.setVariable(variableId, itemData);
        onBindViewHolder(itemData, binding, position);
        //迫使数据立即绑定
        binding.executePendingBindings();
        //设置点击事件
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(itemData, position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return listener.onItemLongClick(itemData, position);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * 绑定数据
     */
    protected void onBindViewHolder(Data data, DB binding, int position) {
    }

    /**
     * 设置新数据
     *
     * @param data
     */
    public void setNewData(List<Data> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 添加数据
     *
     * @param data
     */
    public void addData(Data data) {
        this.data.add(data);
        notifyDataSetChanged();
    }

    /**
     * 添加数据
     *
     * @param data
     */
    public void addData(List<Data> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 设置Item 长按、点击事件
     */
    public void setOnItemListener(OnItemClickListener<Data> listener) {
        this.listener = listener;
    }
}
