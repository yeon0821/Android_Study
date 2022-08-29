package Activity;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.techtown.server_test.databinding.ActivitySubBinding;

import APi.ApiProvider;
import APi.ServerApi;
import Register.RegisterRequest;
import Register.RegisterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

        private ActivitySubBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Singup();
            }
        });
    }

    private void  Singup(){
        String username = binding.tName.getText().toString();
        String password = binding.tPassword.getText().toString();
        String account_id = binding.tId.getText().toString();


        if (username.length() == 0 || account_id.length() == 0 || password.length() == 0) {
            Toast.makeText(RegisterActivity.this, "모든 항목 입력해", Toast.LENGTH_SHORT).show();
        }else{
            RegisterResponse();
        }
    }


    public void RegisterResponse() {
        String username = binding.tName.getText().toString();
        String password = binding.tPassword.getText().toString();
        String account_id = binding.tId.getText().toString();

        RegisterRequest registerRequest = new RegisterRequest(account_id, password, username);
        ServerApi serverApi = ApiProvider.getRetrofit().create(ServerApi.class);

        serverApi.Signup(registerRequest).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "회원가입 성공함", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "오류오류오류", Toast.LENGTH_SHORT).show();
                }
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "통신 실패..", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure: "+t);
                }
            });
    }
}
