package com.example.quizit.data.remote

import com.example.quizit.data.remote.dto.QuizResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizApi{
    @GET
    suspend fun getQuizes(
       @Query("amount") amount:Int,
       @Query("category") category:Int,
       @Query("difficulty") difficulty:String,
       @Query("type") type:String

    ):QuizResponse
}