package com.example.wifiprovider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ThirdScreen(
    onNavigateToSecond: () -> Unit,
    onNavigateToFirst: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Third Screen")
        Button(onClick = onNavigateToSecond) {
            Text(text = "Move to Second")
        }
        Button(onClick = onNavigateToFirst) {
            Text("Move to First")
        }
    }
}