package SplanshActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.techtown.server_test.R;

import Activity.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    private static final String Tag = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        startLoadnig();
    }

    private void startLoadnig(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e(Tag,"Application Running...");
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        },2000);
    }
}
