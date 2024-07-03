package com.example.quizit.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quizit.R
import com.example.quizit.presentation.common.AppDropDownMenu
import com.example.quizit.presentation.common.ButtonBox
import com.example.quizit.presentation.nav_graph.Routes
import com.example.quizit.presentation.util.Constants

import com.example.quizit.presentation.util.Dimens

@Preview
@Composable
fun PrevHome(){
    HomeScreen(state = StateHomeScreen(), event = {}, navController = rememberNavController())
}

@Composable
fun HomeScreen(state: StateHomeScreen,
               event:(EventHomeScreen)->Unit,
               navController: NavController
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        HomeHeader()
        Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))
        AppDropDownMenu(menuName="Number of Questions:",menuList= Constants.numberAsString,onDropDownClick = {event(EventHomeScreen.SetNumberQuizes(it.toInt()))}, text = state.numberOfQuiz.toString())

        Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))
        AppDropDownMenu(menuName="Select Category:",menuList= Constants.categories,onDropDownClick = {event(EventHomeScreen.SetQuizCategory(it))}, text = state.category)

        Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))
        AppDropDownMenu(menuName="Select Difficulty:",menuList= Constants.difficulty,onDropDownClick = {event(EventHomeScreen.SetQuizDifficulty(it))}, text = state.difficulty)

        Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))
        AppDropDownMenu(menuName="Select Type:",menuList= Constants.type,onDropDownClick = {event(EventHomeScreen.SetQuizType(it))}, text = state.type)

        Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))

        ButtonBox(
            text="Generate Quiz",
            padding=Dimens.MediumPadding,
            onClick = {
               navController.navigate(
                   route = Routes.QuizScreen.passQuizParams(state.numberOfQuiz,state.category,state.difficulty,state.type)
               )
            },
           fraction= 1f,
            fontSize=Dimens.SmallTextSize,
            textColor=colorResource(id= R.color.black),
            containerColor=colorResource(id= R.color.uppertext)

        )

    }

}




