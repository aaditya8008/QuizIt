package com.example.quizit.data.remote.dto

import com.example.quizit.domain.model.Quiz

data class QuizResponse(
    val response_code: Int,
    val results: List<Quiz>
)