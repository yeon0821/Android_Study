package org.techtown.retrofit_example;

import retrofit2.Retrofit;


public class Provider {
    private static Retrofit retrofit;
    private static String BASE_URL = "https://jsonplaceholder.typicode.com/posts/1";

    public static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory,create())
                    .build();
        }
        return retrofit;
    }
}
