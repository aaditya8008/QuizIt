package com.example.quizit.presentation.quiz.component

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quizit.R
import com.example.quizit.presentation.common.ButtonBox
import com.example.quizit.presentation.nav_graph.Routes
import com.example.quizit.presentation.quiz.EventQuizScreen
import com.example.quizit.presentation.quiz.StateQuizScreen
import com.example.quizit.presentation.score.goToHome
import com.example.quizit.presentation.util.Constants
import com.example.quizit.presentation.util.Dimens
import kotlinx.coroutines.launch


@Preview
@Composable
fun Prevquiz(){
    QuizScreen(
        numOfQuiz = 3,
        quizCategory = "GK",
        quizDifficulty ="Easy",
        quizType = "Hola",
        event = {  },
        state = StateQuizScreen(),
        navController = rememberNavController()
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuizScreen(
    numOfQuiz: Int,
    quizCategory: String,
    quizDifficulty: String,
    quizType: String,
    event: (EventQuizScreen) -> Unit,
    state: StateQuizScreen,
    navController: NavHostController
){
    BackHandler {
        navController.navigate(Routes.HomeScreen.route){
            popUpTo(Routes.HomeScreen.route){inclusive=true}
        }
    }
    LaunchedEffect(key1 = Unit) {
        val difficulty=when(quizDifficulty){
            "Medium"->"medium"
            "Hard"->"hard"
            else->"easy"
        }
        val type=when(quizType){
            "Multiple Choice"->"multiple"
            else->"boolean"
        }
        event(EventQuizScreen.GetQuizes(numOfQuiz,Constants.categoriesMap[quizCategory]!!,difficulty,type))
    }
    Column(
       modifier= Modifier.fillMaxSize()
    ){
        QuizAppBar(quizCategory=quizCategory,{
            navController.navigate(Routes.HomeScreen.route){
                popUpTo(Routes.HomeScreen.route){inclusive=true}
            }
        })
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
if(quizFetched(state)) {


    val pagerState= rememberPagerState() { state.quizState.size}
    HorizontalPager(state = pagerState){index->
        QuizInterface(
            modifier = Modifier.weight(1f),
            onOptionSelected = {selectedIndex->

event(EventQuizScreen.SetOptionSelected(index,selectedIndex))
            },
            qNumber = index+1,
            quizState = state.quizState[index]
        )
    }
val buttonText by remember {
    derivedStateOf {
        when(pagerState.currentPage){
            0->{
                listOf("","Next")
            }
            state.quizState.size-1->{ listOf("Previous","Submit")}
            else->{ listOf("Previous","")}
        }
    }
}
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Dimens.MediumPadding)
            .navigationBarsPadding()
    ) {
        val scope= rememberCoroutineScope()
        if(buttonText[0].isNotEmpty()) {
            ButtonBox(
                text = "Prev",
                padding = Dimens.SmallPadding,
                fraction = 0.43f,
                fontSize = Dimens.SmallTextSize,
            ) {
                scope.launch { pagerState.animateScrollToPage(pagerState.currentPage-1) }


            }
        }
        else{
            ButtonBox(
                text = "",
                fraction = 0.43f,
                fontSize = Dimens.SmallTextSize,
                borderColor = colorResource(id = R.color.background),
                containerColor = colorResource(id = R.color.background)
            ) {
                scope.launch { pagerState.animateScrollToPage(pagerState.currentPage-1) }


            }
        }

        ButtonBox(
            text = buttonText[1],
            padding = Dimens.SmallPadding,

            fontSize = Dimens.SmallTextSize,
            borderColor = colorResource(id = R.color.orange),
            containerColor = if(pagerState.currentPage==state.quizState.size-1) colorResource(id = R.color.orange) else colorResource(id = R.color.card),
            fraction = 1f,
            textColor = colorResource(id = R.color.uppertext)


        ) {
            if(pagerState.currentPage==state.quizState.size-1){

                 navController.navigate(Routes.ScoreScreen.passNumOfQuestionsAndCorrectAns(state.quizState.size,state.score))

            }
            else {
                scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
            }

        }
    }
}

    }
}
@Composable
fun quizFetched(state: StateQuizScreen): Boolean {
return when{
    state.isLoading->{
        Text(text = "Loading..")
         false
    }
    state.quizState?.isNotEmpty()==true->{
        true
    }
    else-> {
        Text(text = state.error.toString(), color = colorResource(id = R.color.white))
        false
    }

}
}


