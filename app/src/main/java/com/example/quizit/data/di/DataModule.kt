package com.example.quizit.data.di

import com.example.quizit.data.remote.QuizApi
import com.example.quizit.data.repository.QuizRepositriImpt
import com.example.quizit.domain.repository.QuizRepositry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun provideQuizApp():QuizApi{
        return Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .build()
            .create(QuizApi::class.java)

    }
    @Provides
    @Singleton
    fun provideQuizRepository(quizApi: QuizApi): QuizRepositry {
        return QuizRepositriImpt(quizApi)
    }
}