package com.example.listmoves.ui


import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.listmoves.data.State
import com.example.listmoves.data.model.Movie
import com.example.listmoves.data.model.PopularMovieResponse
import com.example.listmoves.data.repository.MovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel:ViewModel(),MovieInteractionListener{

    val repository=MovieRepository()
    val popularMovies=repository.getPopularMovie().asLiveData()

//    private val _movie= MutableLiveData<State<PopularMovieResponse?>>()
//    val movie:LiveData<State<PopularMovieResponse?>>
//    get() = _movie
//
//    fun getPopularMovies(){
//       viewModelScope.launch {
//           repository.getPopularMovie().collect(){
//               _movie.postValue(it)
//           }
//       }
//    }

    override fun onClick(movie: Movie) {
    }
}