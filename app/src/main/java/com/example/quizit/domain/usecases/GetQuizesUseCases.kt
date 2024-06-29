package com.example.quizit.domain.usecases

import com.example.quizit.common.Resource
import com.example.quizit.domain.model.Quiz
import com.example.quizit.domain.repository.QuizRepositry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher

class GetQuizesUseCases (
    val quizRepositry: QuizRepositry
){
fun getQuizes(
    amount: Int,
    category: Int,
    difficulty: String,
    type: String
):Flow<Resource<List<Quiz>>> = flow{
    emit(Resource.Loading())
try {
    emit(Resource.Success(data = quizRepositry.getQuizzes(amount,category,difficulty,type)))
}
catch(e:Exception){
    emit(Resource.Error(message = e.message.toString()))
}

}.flowOn(Dispatchers.IO)

}