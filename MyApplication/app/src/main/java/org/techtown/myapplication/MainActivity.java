package org.techtown.myapplication;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.techtown.myapplication.data.PostAPI;
import org.techtown.myapplication.data.ApiProvider;
import org.techtown.myapplication.data.LoginRequest;
import org.techtown.myapplication.data.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private PostAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_send);
        EditText id = findViewById(R.id.text_id);
        EditText password = findViewById(R.id.text_password);

        api = ApiProvider.getRetrofit().create(PostAPI.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(id.getText().toString(),password.getText().toString());
            }
        });

    }

    private void login(String id, String password){

        LoginRequest loginRequest = new LoginRequest(id,password);

        api.login(loginRequest).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: 성공");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: 실패");;
            }
        });
    }
}