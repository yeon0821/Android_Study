package com.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.text.ui.theme.TextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextTheme {
                    Greeting("Android")

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
   // Text(text = "Hello $name!")

    //색상 지정 color 파라미터를 Color.Red 전달
    //Text(color = Color.Red , text = "Hello $name")

    //Color 객체를 이용해 해쉬값으로 색상 전달
//    Text(color = Color(0xffff4422), text = "Hello $name")

    //fontSize 파라미터에 30.sp 전달
//    Text(color = Color(0xffff4422), text = "Hello $name", fontSize = 30.sp)

    //fontWeight에 FontWeight.Bold를 전달
//    Text(color = Color(0xffff4422), text = "Hello $name", fontSize = 30.sp, fontWeight = FontWeight.Bold)

    //fontFamily에 FontFamily.Cursive를 전달
//    Text(
//        color = Color(0xffff4422),
//        text = "Hello $name",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive
//    )

    //letterSpacing 2.sp 를 지정
//    Text(
//        color = Color(0xffff4422),
//        text = "Hello $name",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp
//    )

    //maxLine 2로 지정하고 문자열을 더 추가
//    Text(
//        color = Color(0xffff4422),
//        text = "Hello $name\nHello $name\nHello $name",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp,
//        maxLines = 2
//    )

    //textDecoration에 TextDecoration.Underline 을 추가
//    Text(
//        color = Color.Red,
//        text = "Hello $name\nHello $name\nHello $name",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp,
//        maxLines = 2,
//        textDecoration = TextDecoration.Underline
//    )

    //textAlign을 TextAlign.Center로 지정
    //modifier = Modifier.width(200.dp)나
    //modifier = Modifier.size(200.dp)를 설정해서 충분히 넓혀준다.
    Text(
        modifier = Modifier.size(200.dp),
        color = Color.Red,
        text = "Hello $name\nHello $name\nHello $name",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 2.sp,
        maxLines = 2,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextTheme {
        Greeting("Android")
    }
}