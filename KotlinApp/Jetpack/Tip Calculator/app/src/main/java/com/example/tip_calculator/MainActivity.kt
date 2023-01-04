@file:Suppress("UNREACHABLE_CODE")

package com.example.tip_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.tip_calculator.components.InputFieId
import com.example.tip_calculator.ui.theme.Tip_CalculatorTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tip_CalculatorTheme {
                MyApp{
                    MainContent()
                }
            }
        }
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit){
    Surface(color = MaterialTheme.colors.background) {

        content()

    }
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun MainContent(){
    val tipAmountState = remember {
        mutableStateOf(0.0)
    }
    val splitByState = remember {
        mutableStateOf(1)
    }
    val totalPerPersonState = remember {
        mutableStateOf(0.0)
    }
    val range = IntRange(start =  1, endInclusive = 100)
    BillForm(
        splitByState = splitByState,
        totalPerPersonState = totalPerPersonState,
        range = range,
        tipAmountState = tipAmountState
    )
}



@ExperimentalComposeUiApi
@Composable
fun BillForm(modifier: Modifier = Modifier,
             range: IntRange = 1..100,
             splitByState: MutableState<Int>,
             tipAmountState: MutableState<Double>,
             totalPerPersonState: MutableState<Double>,
            onValChange: (String) -> Unit = {},
            ){
    val totalBillState = remember {
        mutableStateOf("")
    }
    val validState = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        Column() {
            InputFieId(valueState = totalBillState, labelId = "Enter Bill", enabled = true , isSingleLine =true, onAction = KeyboardActions{
                if (validState!!)
                    onValChange(totalBillState.value.trim())
                    keyboardController?.hide()
                    return@KeyboardActions
            })
            if (validState){
                Row(modifier = Modifier.padding(3.dp),
                horizontalArrangement = Arrangement.Start) {
                    Text("Split",
                        modifier = Modifier.align(
                            alignment =  Alignment.CenterVertically))
                    Spacer(modifier = Modifier.width(120.dp))
                    Row(modifier = Modifier.padding(horizontal = 3.dp),
                    horizontalArrangement = Arrangement.End) {
                Row(modifier = Modifier
                    .padding(horizontal = 3.dp, vertical = 12.dp)) {
                    Text(text = "Tip",
                        modifier = Modifier.align(alignment = Alignment.CenterVertically))
                    Spacer(modifier = Modifier.width(200.dp))
                    Text(text = "$33.00",
                        modifier = Modifier.align(alignment = Alignment.CenterVertically))


                }
                val sliderPositionState = remember {
                    mutableStateOf(0f)
                }
                val tipPercentage = (sliderPositionState.value * 100).toInt()
                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "33%")
                    Spacer(modifier = Modifier.height(14.dp))

                    Slider(value = sliderPositionState.value, onValueChange = { newVal ->
                        sliderPositionState.value = newVal
                        tipAmountState.value =
                            calculateTotalTip(totalBillState.value.toDouble(), tipPercentage)
                        totalPerPersonState.value = calculateTotalPerPerson(
                            totalBillState.value.toDouble(),
                            splitBy = splitByState.value, tipPercentage
                        )
                    },
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        steps = 5,
                        onValueChangeFinished = {

                        })
                }
                    }
                }
            }
            else {
                Box() {}
            }
        }
    }
}


fun calculateTotalTip(totalBill: Double, tipPercentage: Int): Double {
    return if (totalBill > 1 && totalBill.toString().isNotEmpty())
        (totalBill * tipPercentage) / 100
    else 0.0
}
fun calculateTotalPerPerson(totalBill: Double, splitBy: Int, tipPercentage: Int): Double{
    val bill = calculateTotalTip(totalBill = totalBill, tipPercentage = tipPercentage) + totalBill
    return (bill / splitBy)
}




val IconbuttonSizeModifier = Modifier.size(40.dp)
@Composable
fun RoundIconButtons(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    onClick: () -> Unit,
    tint: Color = Color.Black.copy(alpha =  0.8f),
    backgroundColor: Color = MaterialTheme.colors.background,
    elevation: Dp = 4.dp,
) {

    Card(modifier = modifier
        .padding(all = 4.dp)
        .clickable { onClick.invoke() }
        .then(IconbuttonSizeModifier),
    shape = CircleShape,
    backgroundColor = backgroundColor,
    elevation = elevation) {
        Icon(imageVector = imageVector, contentDescription = "Plus or Minus icon", tint =  tint )
    }
}

@Preview
@Composable
fun TopHeader(totalPerPerson: Double = 0.0){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .clip(shape = CircleShape.copy(all = CornerSize(12.dp))),
        color = Color(color = 0xFF4666d0)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val total = "%.2f".format(totalPerPerson)
            Text(text = "Total Per Person",
                 style = MaterialTheme.typography.h4)
            Text(text = "$$total",
                 style = MaterialTheme.typography.h4,
                 fontWeight = FontWeight.ExtraBold)
        }

    }
}


@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Tip_CalculatorTheme {
        MyApp {
            MainContent()
        }
    }
}