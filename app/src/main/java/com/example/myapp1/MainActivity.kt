package com.example.myapp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp1.ui.theme.MyApp1Theme
import androidx.compose.ui.Alignment.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Magenta

                ) {

                }
                Surface(
                    modifier = Modifier.padding(30.dp),
                    color = Color.Gray

                )
                {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var numberOne by remember { mutableStateOf("") }
    var numberTwo by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column (modifier = Modifier.padding(30.dp)) {

        Text(
            color = Color.Green,
            text = "Hello $name!",
            modifier = modifier
                .background(Color.Blue)
                .padding(122.dp)

        )
        OutlinedTextField(
            value = numberOne,
            onValueChange = { numberOne = it }
        )
        OutlinedTextField(
            value = numberTwo,
            onValueChange = { numberTwo = it },
            modifier = modifier.background(Color.Red)

        )
        OutlinedTextField(value = result, onValueChange = { result = it })
        Row {
                Button(onClick = { result = subtractNumbers(numberOne, numberTwo) }) {
                    Text(text = "Subtract!")

                }

                Button(onClick = { result = addNumbers(numberOne, numberTwo) }) {
                    Text(text = "Add")
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                 }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Multiply")

            }



        }

    }



}

fun addNumbers(numberOne: String, numberTwo: String): String {
    return (numberOne.toDouble() + numberTwo.toDouble()).toString()
}
fun subtractNumbers(numberOne: String, numberTwo: String): String {
    return (numberOne.toDouble() - numberTwo.toDouble()).toString()
}

