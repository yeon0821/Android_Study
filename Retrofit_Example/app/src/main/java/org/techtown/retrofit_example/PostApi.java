package org.techtown.retrofit_example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostApi {
    @GET("post/{post-id}")
    Call<PostResponse> fetchPost(@Path("post-id") int postId);
}
