package org.techtown.myapplication.data;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    @POST("user/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

}
