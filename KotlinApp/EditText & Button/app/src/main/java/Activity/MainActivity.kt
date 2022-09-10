package Activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.techtown.edittextbutton.R


class MainActivity {

    class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            var Edit = findViewById<EditText>(R.id.Edit)
            var Btn = findViewById<Button>(R.id.Btn)

            Btn.setOnClickListener{
                var resultText = Edit.text.toString()
                Btn.setText(resultText)
            }


        }
    }
}



