package compose.button

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.button.ui.theme.ButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonTheme {
                ButtonExample(onButtonClicked = {
                    Toast.makeText(this,"Send clicked.", Toast.LENGTH_SHORT).show()
                })
            }
        }
    }
}

@Composable
fun ButtonExample(onButtonClicked: () -> Unit) {
//    Button(onClick = onButtonClicked){
//        Text(text = "Send")
//    }
    // Button을 클릭 했을 때 Toast 출력


    //Icon을 Text 앞에 추가
    //imageVector에는  Icons.Filled.Send를 넣고 ,
    //contentDescription에는 nul
//    Button(onClick = onButtonClicked){
//        Icon(
//           imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Text(text = "Send")
//    }


    //아이콘과 텍스트 사이 Spacer를 넣고
    //modifier에 Modifier.size를 넣어 사이즈를
    //ButtonDefaults.IconSpacing에 지정
//    Button(onClick = onButtonClicked){
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

    //enabled를 false로 바꾸기.
//    Button(
//        onClick = onButtonClicked,
//        enabled = false
//    ){
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

    //border에 BorderStroke를 설정
//    Button(
//        onClick = onButtonClicked,
//        enabled = true,
//        border = BorderStroke(5.dp, Color.Magenta)
//    ){
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

    //shape를 CircleShape로 지정
//    Button(
//        onClick = onButtonClicked,
//        border = BorderStroke(10.dp, Color.Magenta),
//        shape = CircleShape
//    ){
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

    //contentPadding에 PaddingValues를 설정
    Button(
        onClick = onButtonClicked,
        border = BorderStroke(10.dp, Color.Magenta),
        shape = CircleShape,
        contentPadding = PaddingValues(20.dp)
    ){
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Send")
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ButtonTheme {
            ButtonExample(onButtonClicked = {})
    }
}