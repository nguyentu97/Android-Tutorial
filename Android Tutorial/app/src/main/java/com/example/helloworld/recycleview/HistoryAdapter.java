package com.example.helloworld.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.helloworld.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    Context context;
    ArrayList<History> data;
    ImageView img_icon;

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item_layout,viewGroup,false);
        HistoryViewHolder historyViewHolder = new HistoryViewHolder(view);
        return historyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int i) {
        History history = data.get(i);
        holder.tvHistoryID.setText("HistoryID: "+history.getHistoryID()+"");
        holder.tvCustomerID.setText("CustomerID: "+history.getCustomerID()+"");
        holder.tvCustomerName.setText("CustomerName: "+history.getCustomerName());
        holder.tvPoint.setText("+"+history.getPoint()+"");
        holder.tvAddPointCode.setText("AddPointCode: "+history.getAddpointCode());
        holder.tvCode.setText("Code: "+history.getCode());
        holder.tvCreateDate.setText("CreateDate: "+history.getCreateDate());
        holder.tvCreateDateStr.setText("CreateDateStr: "+history.getCreateDateStr());
        holder.tvTypeAdd.setText("TypeAdd: "+history.getTypeAdd()+"");
        holder.tvType.setText("Type: "+history.getType()+"");
        holder.tvTitle.setText(history.getTitle());
        holder.tvBalance.setText("Balance: "+history.getBalance()+"");
        Picasso.get().load(history.getIcon()).into(img_icon);

    }

    @Override
    public int getItemCount() {
        return data.size() ;
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder{
        TextView tvHistoryID,tvCustomerID,tvCustomerName,tvPoint,tvAddPointCode,
                tvCode,tvCreateDate,tvCreateDateStr,tvTypeAdd,tvType,tvTitle,tvBalance;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
             tvHistoryID = itemView.findViewById(R.id.tv_history_id);
             tvCustomerID = itemView.findViewById(R.id.tv_customer_id);
             tvCustomerName = itemView.findViewById(R.id.tv_customer_name);
             tvPoint = itemView.findViewById(R.id.tv_point);
             tvAddPointCode = itemView.findViewById(R.id.tv_add_point_code);
             tvCode = itemView.findViewById(R.id.tv_code);
             tvCreateDate = itemView.findViewById(R.id.tv_create_date);
             tvCreateDateStr = itemView.findViewById(R.id.tv_create_date_str);
             tvTypeAdd = itemView.findViewById(R.id.tv_type_add);
             tvType = itemView.findViewById(R.id.tv_type);
             tvTitle = itemView.findViewById(R.id.tv_title);
             tvBalance = itemView.findViewById(R.id.tv_balance);
             img_icon = itemView.findViewById(R.id.img_icon);
        }
    }
}
