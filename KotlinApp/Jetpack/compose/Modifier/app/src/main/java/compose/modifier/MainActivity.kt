package compose.modifier

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.modifier.ui.theme.ModifierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierTheme {
                ModifierEx()
            }
        }
    }
}

@Composable
fun ModifierEx() {
//    Button(onClick = {}){
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//    }
//    Text("Search")

    //modifier에 Modifier.fillMaxSize() 적용
//    Button(onClick = {}, modifier = Modifier.fillMaxSize()) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }


    //fillMaxSize() 대신 Modifier.height를 설정
//    Button(
//        onClick = {},
//        modifier = Modifier.height(100.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    //modifier에 width와 같이 설정
//    Button(
//        onClick = {},
//        modifier = Modifier
//            .height(100.dp)
//            .width(200.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    //size에 width와 height를 인자로 넣기
//    Button(
//        onClick = {},
//        modifier = Modifier
//            .size(200.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    //background를 설정(버튼에서는 되지 않음)
    //Button에 되지 않으면 Text나 Icon에 지정.
//    Button(
//        onClick = {},
//        modifier = Modifier.size(200.dp).background(Color.Red)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    //colors 파라미터에 ButtonDefaluts.buttonColors를 넣기
    //backgroundColor와 contentColor 프로퍼티를 설정.
//    Button(
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = Color.Magenta,
//            contentColor = Color.Cyan
//        ),
//        onClick = {},
//        modifier = Modifier
//            .size(200.dp)
//            .background(Color.Red)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    //Button의 modifier에 padding을 추가
//    Button(
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = Color.Magenta,
//            contentColor = Color.Cyan
//        ),
//        onClick = {},
//        modifier = Modifier.size(200.dp).padding(30.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    //Button에 enabled를 false로 설정하고, Text의
    //modifier에 clickable 추가.
//    Button(
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = Color.Magenta,
//            contentColor = Color.Cyan
//        ),
//        enabled = false,
//        onClick = {},
//        modifier = Modifier.size(200.dp).padding(30.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search", modifier = Modifier.clickable {})
//    }

    //Text의 modifier에 offset를 설정하고 x 파라미터를 설정

    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Magenta,
            contentColor = Color.Cyan
        ),
        onClick = {},
        modifier = Modifier.size(200.dp).padding(30.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier.background(Color.Blue)
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
                .background(Color.Blue)
        )
        Text("Search",
            modifier = Modifier
                .offset(x = 10.dp)
                .background(Color.Blue)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModifierTheme {
        ModifierEx()
    }
}