package com.example.quizit.data.repository

import android.util.Log
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
        Log.d("quiz", "RepositryStart")
        val rsp=quizApi.getQuizes(amount,category,difficulty,type).results
        Log.d("quiz", "RepositryEnd")
        Log.d("quiz", rsp.toString())
        return rsp
    }
}