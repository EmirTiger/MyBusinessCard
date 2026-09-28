package com.example.mybusinesscard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybusinesscard.ui.theme.MyBusinessCardTheme

@Composable
fun SharedScreen(){
    Column() {
        OuterMargin()
        InnerMargin()
    }
}

@Composable
fun OuterMargin(){  // Внешний отступ
    Text(
        "Эмир",
              modifier = Modifier
                  .border(3.dp, color = Color.Black)
                  .background(Color.Yellow)
                .padding(16.dp)
    )


}

@Composable
fun InnerMargin(){
    Text(
        "Emir",
        modifier = Modifier
            .border(3.dp, color = Color.Black)
            .padding(16.dp)
            .background(Color.Yellow)
    )
}

@Preview(showBackground = true)
@Composable
fun SharedScreenPreview() {
    MyBusinessCardTheme {
        SharedScreen()
    }
}