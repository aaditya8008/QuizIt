package com.example.quizit.presentation.quiz.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.quizit.R
import com.example.quizit.presentation.util.Constants
import com.example.quizit.presentation.util.Dimens

@Preview
@Composable
fun Prevquiz(){
    QuizScreen(numOfQuiz = 3, quizCategory = "GK", quizDifficulty ="Easy" )

}

@Composable
fun QuizScreen(
    numOfQuiz:Int,
    quizCategory:String,
    quizDifficulty:String
){
    Column(
       modifier= Modifier.fillMaxSize()
    ){
        QuizAppBar(quizCategory=quizCategory,{})
    }
    Column(
        modifier = Modifier
            .padding(Dimens.VerySmallPadding)
            .fillMaxSize()
    ){
Spacer(modifier = Modifier.height(Dimens.LargeSpacerHeight))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Questions : $numOfQuiz",
                color = colorResource(id = R.color.uppertext)
            )
            Text(
                text = quizDifficulty,
                color = colorResource(id = R.color.uppertext)
            )

        }

        Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))
        Box (
          modifier = Modifier
              .fillMaxWidth()
              .height(Dimens.VerySmallViewHeight)
              .clip(RoundedCornerShape(Dimens.MediumCornerRadius))
              .background(
                  colorResource(id = R.color.uppertext)
              ),
        )
        Spacer(modifier = Modifier.height(Dimens.LargeSpacerHeight))

    }
}


