package com.example.wifiprovider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FirstScreen(
    onFirstScreenClicked: (String,Int) -> Unit
) {
    var name by remember {
        mutableStateOf("")
    }

    var age by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        Text(text = "First Screen")
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text(text = "Enter Text")
            }
        )

        Button(
            onClick = {
                onFirstScreenClicked(name,27)
            }
        ) {
            Text("Go to Second Screen")
        }
    }

}


