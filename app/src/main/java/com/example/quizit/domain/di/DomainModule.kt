package com.example.quizit.domain.di

import com.example.quizit.data.remote.QuizApi
import com.example.quizit.data.repository.QuizRepositriImpt
import com.example.quizit.domain.repository.QuizRepositry
import com.example.quizit.domain.usecases.GetQuizesUseCases
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {
fun provideGetQuizesUseCases(quizRepositry: QuizRepositry):GetQuizesUseCases{
    return GetQuizesUseCases(quizRepositry)
}
}