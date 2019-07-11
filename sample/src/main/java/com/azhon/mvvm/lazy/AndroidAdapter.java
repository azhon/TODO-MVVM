package com.azhon.mvvm.lazy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhon.mvvm.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.lazy
 * 文件名:    AndroidAdapter
 * 创建时间:  2019-03-29 on 10:44
 * 描述:     TODO
 *
 * @author 阿钟
 */
public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.VHolder> {

    private List<JueJinBean.DBean.EntrylistBean> list = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jue_jin, parent, false);
        return new VHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHolder holder, final int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.content.setText(list.get(position).getContent());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(list.get(position), position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setNewData(List<JueJinBean.DBean.EntrylistBean> stories) {
        list.clear();
        list.addAll(stories);
        notifyDataSetChanged();

    }

    public void setOnItemListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public class VHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView content;

        public VHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(JueJinBean.DBean.EntrylistBean bean, int position);
    }
}