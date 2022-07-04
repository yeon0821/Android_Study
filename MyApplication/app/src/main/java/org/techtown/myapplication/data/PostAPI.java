package org.techtown.myapplication.data;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostAPI {
    @POST("/post")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

}



