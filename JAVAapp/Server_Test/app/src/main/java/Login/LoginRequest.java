package Login;

import android.text.Editable;

public class LoginRequest {

    private String account_id;
    private String password;

    public LoginRequest(String account_id, String password) {
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
