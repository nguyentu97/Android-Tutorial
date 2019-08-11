package com.example.helloworld.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloworld.R;
import com.example.helloworld.recycleview.model.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    Context context;
    ArrayList<Category> data;

    public CategoryAdapter(Context context, ArrayList<Category> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item_layout,viewGroup,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        Category category = data.get(i );
        categoryViewHolder.tvCategory.setText(category.name);
        Picasso.get().load(category.urlCategory).into(categoryViewHolder.imgCategory);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class  CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategory;
        ImageView imgCategory;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.tv_name_category);
            imgCategory = itemView.findViewById(R.id.img_category);
        }
    }
}
