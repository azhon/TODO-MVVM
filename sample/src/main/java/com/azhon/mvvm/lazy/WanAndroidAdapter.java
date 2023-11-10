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
 * createDate: 2019/03/27 on 14:155
 * desc:
 *
 * @author azhon
 */
public class WanAndroidAdapter extends RecyclerView.Adapter<WanAndroidAdapter.VHolder> {

    private final List<CategoryBean.DataBean.DatasBean> list = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wan_android, parent, false);
        return new VHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.content.setText(list.get(position).getDesc());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(list.get(position), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setNewData(List<CategoryBean.DataBean.DatasBean> stories) {
        list.clear();
        list.addAll(stories);
        notifyDataSetChanged();

    }

    public void setOnItemListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public static class VHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView content;

        public VHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(CategoryBean.DataBean.DatasBean bean, int position);
    }
}