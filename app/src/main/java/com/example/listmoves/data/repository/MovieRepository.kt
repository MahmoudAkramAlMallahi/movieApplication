package com.example.listmoves.data.repository

import com.example.listmoves.data.Constants
import com.example.listmoves.data.State
import com.example.listmoves.pojo.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MovieRepository {

    fun getPopularMovie()= wrapWithFlow { API.apiService.getPopularMovies(Constants.API_KAY) }

    //flow عمليه تحويلي من corotuines الى
    fun <T> wrapWithFlow(function:suspend ()-> Response<T>): Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try{
                val result=function()
                if (result.isSuccessful) {
                    emit(State.Success(result.body()))
                }else{
                    emit(State.Error(result.message()))
                }
            }catch (e:Exception){
                emit(State.Error(e.message.toString()))
            }
        }

    }
}