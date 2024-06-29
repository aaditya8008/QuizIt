package com.example.quizit.presentation.quiz

import androidx.lifecycle.ViewModel
import com.example.quizit.domain.usecases.GetQuizesUseCases
import javax.inject.Inject

class QuizViewModel @Inject constructor(private val getQuizesUseCases: GetQuizesUseCases):ViewModel() {
}