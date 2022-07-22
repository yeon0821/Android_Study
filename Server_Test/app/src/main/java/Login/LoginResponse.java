package Login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    private String account_id;
    private String password;

    public LoginResponse(String account_id, String password){
    }

    public String getAccount_id() {
        return account_id;
    }

    public String getPassword() {
        return password;
    }
}
