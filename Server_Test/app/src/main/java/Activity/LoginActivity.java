package Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.server_test.databinding.ActivityMainBinding;

import APi.ApiProvider;
import APi.ServerApi;
import Login.LoginRequest;
import Login.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Singin();
            }
        });
    }

    private void Singin(){
        String account_id = binding.textId.getText().toString();
        String Password = binding.textPw.getText().toString();

        if (account_id.length() == 0){
            Toast.makeText(LoginActivity.this,"아이디 뺴먹음 입력해", Toast.LENGTH_SHORT).show();;
        }else if (Password.length() == 0 ) {
            Toast.makeText(LoginActivity.this, "비밀번호 빼먹음 입력해", Toast.LENGTH_SHORT).show();
        }else{
            LoginResponse();
        }
    }

    public void LoginResponse() {
        String account_id = binding.textId.getText().toString();
        String password = binding.textPw.getText().toString();

        LoginRequest loginRequest = new LoginRequest(account_id, password);
        ServerApi serverApi = ApiProvider.getRetrofit().create(ServerApi.class);
        serverApi.login(loginRequest).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "로그인 성공~~~", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "로그인 실패... ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}