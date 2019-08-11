package com.example.helloworld.recycleview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.helloworld.R;
import com.example.helloworld.recycleview.model.Places;

import java.util.ArrayList;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder> {

   Context context;
   ArrayList<Places> data;

    public PlacesAdapter(Context context, ArrayList<Places> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.places_item_layout,viewGroup,false);
        PlacesViewHolder placesViewHolder = new PlacesViewHolder(view);
        return placesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesViewHolder placesViewHolder, int i) {
        Places places = data.get(i);
        placesViewHolder.tvNamePlaces.setText(places.getNamePlaces());
//        placesViewHolder.tvIsMoreDetail.setText(places.getIsMoreDetail()+"");
//        placesViewHolder.tvIsPromotion.setText(places.getIsPromotion()+"");
        if(places.isMoreDetail==1&&places.isPromotion==1){
            placesViewHolder.tvIsMoreDetail.setVisibility(View.VISIBLE);
            placesViewHolder.tvIsPromotion.setVisibility(View.VISIBLE);
            placesViewHolder.lnPlaces.setBackgroundColor(Color.parseColor("#FF9800"));
        }else if(places.isMoreDetail==1&&places.isPromotion==0){
            placesViewHolder.tvIsMoreDetail.setVisibility(View.INVISIBLE);
            placesViewHolder.tvIsPromotion.setVisibility(View.VISIBLE);
            placesViewHolder.lnPlaces.setBackgroundColor(Color.parseColor("#FF9800"));

        }else {
            placesViewHolder.tvIsMoreDetail.setVisibility(View.INVISIBLE);
            placesViewHolder.tvIsPromotion.setVisibility(View.VISIBLE);
            placesViewHolder.lnPlaces.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PlacesViewHolder extends RecyclerView.ViewHolder{

        TextView tvNamePlaces,tvIsMoreDetail,tvIsPromotion;
        LinearLayout lnPlaces;

        public PlacesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamePlaces = itemView.findViewById(R.id.tv_name_places);
            tvIsMoreDetail = itemView.findViewById(R.id.tv_is_more_detail);
            tvIsPromotion = itemView.findViewById(R.id.tv_is_promotion);
            lnPlaces = itemView.findViewById(R.id.ln_places);
        }
    }
}
