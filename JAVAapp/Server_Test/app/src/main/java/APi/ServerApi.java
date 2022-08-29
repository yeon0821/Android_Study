package APi;

import Login.LoginRequest;
import Login.LoginResponse;
import Register.RegisterRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServerApi {

    @POST("/user/login")
    Call<LoginResponse> login(
            @Body LoginRequest loginRequest
    );


    @POST("/user/signup")
    Call<Void> Signup(
            @Body RegisterRequest registerRequest
    );
}
