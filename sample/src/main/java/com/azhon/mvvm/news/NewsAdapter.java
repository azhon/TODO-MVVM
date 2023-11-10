package com.azhon.mvvm.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhon.mvvm.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * createDate: 2019/03/27 on 14:155
 * desc:
 *
 * @author azhon
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.VHolder> {

    private final List<NewsBean.StoriesBean> list = new ArrayList<>();

    @NonNull
    @Override
    public VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nes, parent, false);
        return new VHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHolder holder, int position) {
        holder.text.setText(list.get(position).getTitle());
        holder.text1.setText(list.get(position).getGa_prefix());
        loadImage(holder.imageView, list.get(position).getImages().get(0));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setNewData(List<NewsBean.StoriesBean> stories) {
        list.clear();
        list.addAll(stories);
        notifyDataSetChanged();

    }

    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }


    public static class VHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public TextView text1;
        public ImageView imageView;

        public VHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            text1 = itemView.findViewById(R.id.text1);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
