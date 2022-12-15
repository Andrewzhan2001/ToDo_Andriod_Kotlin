package com.example.to_doapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_doapp.data.models.TodoTask
import com.example.to_doapp.data.repositories.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: TodoRepository
) :ViewModel() {

    private val _allTasks =
        MutableStateFlow<List<TodoTask>>(emptyList())
    val allTasks: StateFlow<List<TodoTask>> = _allTasks

    fun getAllTasks() {
        // scope tide to lifecycle of viewModel
        viewModelScope.launch {
            // Trigger the flow and consume its elements using collect
            repository.getAllTasks.collect {
                _allTasks.value = it
            }
        }
    }
}