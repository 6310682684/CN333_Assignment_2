package com.example.quizzapp

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizzapp.ui.theme.QuizzAppTheme
import java.util.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizzAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var numberGen = (0 .. 9).random()
    var randomIndex by remember {
        mutableStateOf(numberGen)
    }
    var res = ""
    val allQuestions = mutableListOf(
        "2 + 5 = ?",
        "3 x 2 = ?",
        "24 ÷ 4 = ?",
        "12 - 5 = ?",
        "169 ÷ 13 = ?",
        "9 + 43 = ?",
        "15 - 13 = ?",
        "16 x 7 = ?",
        "19 + 5 = ?",
        "26 - 3 = ?"
    )

    allQuestions.shuffle()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.Title),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(32.dp))

        Button(
            onClick = {randomIndex = (0 until(allQuestions.size)).random() }) {
            Text(text = "Next Question")
            }
        Spacer(Modifier.height(32.dp))

        Text(
            text = allQuestions[randomIndex],
            fontSize = 24.sp
        )

        Spacer(Modifier.height(32.dp))
        Text(text = res)
        if (allQuestions[randomIndex] == "2 + 5 = ?") {
            res = "true"
            Text(text = res)
        }
        else {
            res = "false"
            Text(text = res)
        }


    }
    
    

}


fun ShuffleAnswers(modifier: Modifier = Modifier){
    val answer1 = mutableListOf(
        "7","14","11","5"
    )

    val answer2 = mutableListOf(
        "6","15","20","25"
    )

    val answer3 = mutableListOf(
        "6","15","20","25"
    )

    val answer4 = mutableListOf(
        "7","15","20","25"
    )

    val answer5 = mutableListOf(
        "13","15","20","25"
    )

    val answer6 = mutableListOf(
        "52","15","20","25"
    )

    val answer7 = mutableListOf(
        "2","15","20","25"
    )

    val answer8 = mutableListOf(
        "112","15","20","25"
    )

    val answer9 = mutableListOf(
        "24","15","20","25"
    )

    val answer10 = mutableListOf(
        "23","15","20","25"
    )

    answer1.shuffle()
    answer2.shuffle()
    answer3.shuffle()
    answer4.shuffle()
    answer5.shuffle()
    answer6.shuffle()
    answer7.shuffle()
    answer8.shuffle()
    answer9.shuffle()
    answer10.shuffle()

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuizzAppTheme {
        MainScreen()
    }
}

