package com.example.listmoves.data

sealed interface State <out T>{
    data class Success<T>(val data:T): State<T>
    data class Error(val data:String):State<Nothing>
    object  Loading:State<Nothing>

    fun ToData(): T? = if (this is Success) data else null
}