package com.example.click_the_money_up

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.click_the_money_up.ui.theme.Click_the_money_upTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Click_the_money_upTheme {

                MyApp()

            }
        }
    }
}


@Composable
fun MyApp(){
    var moneyCounter = remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        color = Color(0xFF4666d0)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "$${moneyCounter.value}", style = TextStyle(
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.ExtraBold
            ))
            Spacer(modifier = Modifier.height(130.dp))
            CreateCircle(moneyCounter = moneyCounter.value){ newValue ->
                moneyCounter.value = newValue + 1
            }

            if (moneyCounter.value > 10){
                Text("Over $10 !!")
            }
        }
    }
}



@Composable
fun CreateCircle(moneyCounter: Int = 0, updateMoneyCounter: (Int) -> Unit){
    Card(modifier = Modifier
        .padding(3.dp)
        .size(50.dp)
        .clickable {
            updateMoneyCounter(moneyCounter)
            Log.d("Counter", "CreateCircle : $moneyCounter")
        },
        shape = CircleShape,
        elevation = 4.dp){

        Box(contentAlignment = Alignment.Center){
            Text(text = "Tap $moneyCounter", modifier = Modifier)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Click_the_money_upTheme {

        MyApp()

    }
}

