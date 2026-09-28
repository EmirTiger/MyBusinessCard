package com.example.mybusinesscard

import android.R.attr.text
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybusinesscard.ui.theme.MyBusinessCardTheme
import java.time.LocalDate
import java.time.Period

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = applicationContext
            MyBusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        StudentCard()
                    }
                }
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StudentCard() {
    val message = remember{
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android),
            contentDescription = "Логотип Android Studio" // Важно для доступности
        )
        Text(text = "Имя: Эмир", fontSize = 20.sp)
        Text(text = "Возраст: ${getAge()} лет", fontSize = 20.sp)
        Text(text = "Любимый язык: Kotlin", fontSize = 20.sp)
        Text(message.value)

        Button(onClick = {
            message.value = "Привет! Я изучаю Kotlin!"
            //Thread.sleep(3000)
           // message.value = ""
        }) {
            Text("Нажми на меня")
        }
    }

}
fun getAge(): Int {
    val birthDate = LocalDate.of(2010, 7, 18)
    val currentDate = LocalDate.now()
    return Period.between(birthDate, currentDate).years
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyBusinessCardTheme {
        StudentCard()
    }
}