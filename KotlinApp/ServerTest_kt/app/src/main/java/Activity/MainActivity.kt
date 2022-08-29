package Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.servertest_kt.R
import com.example.servertest_kt.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.join.setOnClickListener {
            val request = Request(binding.mId.text.toString(), binding.mPassword.text.toString(), binding.mName.text.toString())

            ApiProvider.retrofit.signup(request).enqueue(object: Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                }

            })
        }
    }
}