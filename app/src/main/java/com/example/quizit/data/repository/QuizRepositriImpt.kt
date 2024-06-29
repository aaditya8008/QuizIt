package com.example.quizit.data.repository

import com.example.quizit.data.remote.QuizApi
import com.example.quizit.domain.model.Quiz
import com.example.quizit.domain.repository.QuizRepositry

class QuizRepositriImpt(
    private val quizApi: QuizApi
):QuizRepositry {
    override suspend fun getQuizzes(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): List<Quiz> {
       return quizApi.getQuizes(amount,category,difficulty,type).results
    }
}