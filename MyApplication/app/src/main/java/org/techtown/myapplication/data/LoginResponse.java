package org.techtown.myapplication.data;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("accessToken")
    String accessToken;

    public String getAccessToken() {
        return accessToken;
    }    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
