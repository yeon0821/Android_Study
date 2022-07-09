package org.techtown.myapplication.data;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("accountId")
    String accountId;

    @SerializedName("password")
    String password;

    public LoginRequest(String accountId, String password){
        this.accountId = accountId;
        this.password = password;
    }

    public String getAccountId() {

        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}
