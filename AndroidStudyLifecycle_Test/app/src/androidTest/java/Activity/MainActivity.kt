package Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lifecycle_test.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}