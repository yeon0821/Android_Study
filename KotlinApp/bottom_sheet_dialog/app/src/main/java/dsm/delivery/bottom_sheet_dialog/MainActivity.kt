package dsm.delivery.bottom_sheet_dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialog


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(bottomSheetView)

        findViewById<Button>(R.id.button).setOnClickListener{
            bottomSheetDialog.show()
        }

    }
}