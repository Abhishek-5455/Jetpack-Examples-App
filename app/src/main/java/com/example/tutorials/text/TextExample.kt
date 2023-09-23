package com.example.tutorials.text

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorials.ui.theme.TutorialsTheme

@Composable
fun TextExample(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(onClick = {
            //your onclick code here
        }) {
            Text(text = "Simple Button")
        }

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text(text = "Button with gray background",color = Color.White)
        }

        Button(onClick = {}) {

            Icon(
                imageVector = Icons.Rounded.Home,
                contentDescription = null
            )

            Text(text = "Add to cart",Modifier.padding(start = 10.dp))
        }

        Button(onClick = {}, shape = RectangleShape) {
            Text(text = "Rectangle shape")
        }

        Button(onClick = {}, shape = RoundedCornerShape(20.dp)) {
            Text(text = "Round corner shape")
        }

        Button(onClick = {}, shape = CutCornerShape(10)) {
            Text(text = "Cut corner shape")
        }

        Button(
            onClick = {
                //your onclick code
            },
            border = BorderStroke(1.dp, Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
        ) {
            Text(text = "Button with border", color = Color.DarkGray)
        }

        Button(onClick = {
            //your onclick code here
        },elevation =  ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )) {
            Text(text = "Button with elevation")
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun DefaultTextScreen() {
    TutorialsTheme {
        TextExample()
    }
}

