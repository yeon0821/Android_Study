package Api;

import Login.LoginRequest;
import Register.RegisterRequest;
import Register.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServerApi {

    @POST("user/login")
    Call<Void> login(
            @Body LoginRequest loginRequest
    );


    @POST("user/signup")
    Call<Void> Signup(
            @Body RegisterRequest registerRequest
    );
}
