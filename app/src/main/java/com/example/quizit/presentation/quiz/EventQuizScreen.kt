package com.example.quizit.presentation.quiz

sealed class EventQuizScreen {

    data class GetQuizes(
        val numOfQuizzes:Int,
        val category:Int,
        val difficulty:String,
        val type:String
    ):EventQuizScreen()

    data class SetOptionSelected(
        val quizStateIndex:Int,
        val selectedOption:Int
    ):EventQuizScreen()

}