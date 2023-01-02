package com.example.to_doapp.util

//allow using encrypt algorithm to create class for secret protection
sealed class RequestState<out T> {
    object Idle: RequestState<Nothing>()
    object Loading : RequestState<Nothing>()
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error(val error: Throwable): RequestState<Nothing>()
}
