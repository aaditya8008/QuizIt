package com.example.quizit.presentation.home

sealed class EventHomeScreen {

    data class SetNumberQuizes(val num: Int) : EventHomeScreen()
    data class SetQuizCategory(val category:String) : EventHomeScreen()
    data class SetQuizType(val type:String) : EventHomeScreen()
    data class SetQuizDifficulty(val difficulty:String) : EventHomeScreen()

}