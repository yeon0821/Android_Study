package Activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.techtown.lifecycle_test.R

class MainActivity : AppCompatActivity() {
    // 최초로 Activity가 생성 될 때 실행되는 메서드 단 한 번만 호출 된다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Life_cyle", "onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Life_cyle", "onRestart")
    }

    // onCreate() 이후에 실행 된다 Activity가 실행되며 사용자가 앱과 상호 작용을 준비한다.
    override fun onStart() {
        super.onStart()
        Log.d("Life_cyle", "onStart")
    }

    //     다시 앱으로 돌아올 때 호출 된다.
    override fun onResume() {
        super.onResume()
        Log.d("Life_cyle", "onResume")
    }

    //     화면의 일부가 가려 졌을 떄
    override fun onPause() {
        super.onPause()
        Log.d("Life_cyle", "onPause")
    }

    //    화면 전부가 보이지 않을 때때
    override fun onStop() {
        super.onStop()
        Log.d("Life_cyle", "onStop")
    }

    //    완전히 소멸 되기전에 실행
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life_cyle", "onDestroy")
    }
}