package view
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.Activity.R
import com.Activity.databinding.ActivityMainBinding
import viewModel.MainViewModel
import kotlin.properties.ReadOnlyProperty

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private val model : MainViewModel by viewModels()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainBinding.lifecycleOwner = this
        mainBinding.viewModel = model

        var  SetMaxnum = findViewById<Button>(R.id.setMaxNumbtn)

        SetMaxnum.setOnClickListener{
            var intent = Intent(this, SetMaxActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}