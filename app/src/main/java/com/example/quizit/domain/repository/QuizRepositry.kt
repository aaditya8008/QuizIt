package com.example.quizit.domain.repository

import com.example.quizit.domain.model.Quiz

interface QuizRepositry {
    suspend fun getQuizzes(amount:Int,category:Int,difficulty:String,type:String):List<Quiz>
}