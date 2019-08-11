package com.example.helloworld.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.helloworld.R;
import com.example.helloworld.recycleview.model.UserfullName;

import java.util.ArrayList;

public class UserfullPhoneAdapter extends RecyclerView.Adapter<UserfullPhoneAdapter.UserfullNameViewHolder> {
    Context context;
    ArrayList<UserfullName> data;

    public UserfullPhoneAdapter(Context context, ArrayList<UserfullName> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public UserfullNameViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.userfullphone_item_layout, viewGroup, false);
        return new UserfullNameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserfullNameViewHolder userfullNameViewHolder, int i) {
        UserfullName userfullName = data.get(i);
        userfullNameViewHolder.tvName.setText(userfullName.getName());
        userfullNameViewHolder.tvPhone.setText(userfullName.getPhone());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class UserfullNameViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPhone;

        public UserfullNameViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_userfullphone);
            tvPhone = itemView.findViewById(R.id.tv_phone);
        }
    }
}
