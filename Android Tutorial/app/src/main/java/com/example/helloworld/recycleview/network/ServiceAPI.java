package com.example.helloworld.recycleview;

import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceAPI {
    @POST("Service/GetListContact")
    Call<UserfullNameResponse>getListUserfullName(@Body JSONObject jsonObject);

}
