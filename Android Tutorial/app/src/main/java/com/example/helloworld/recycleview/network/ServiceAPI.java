package com.example.helloworld.recycleview.network;

import com.example.helloworld.recycleview.model.ListCategoryResponse;
import com.example.helloworld.recycleview.model.UserfullNameResponse;

import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceAPI {
    @POST("Service/GetListContact")
    Call<UserfullNameResponse>getListUserfullName(@Body JSONObject jsonObject);
    @POST("Service/GetListCategoryAndBanner")
    Call<ListCategoryResponse>getListCategory();

}
