package com.example.to_doapp.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_doapp.ui.data.models.TodoTask
import com.example.to_doapp.ui.data.repositories.TodoRepository
import com.example.to_doapp.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


// this class shows all the variables either get from hilt, provide those value to view (contains all data required for view)
@HiltViewModel
class SharedViewModel @Inject constructor( private val repository: TodoRepository ) :ViewModel() {
    val searchAppBarState: MutableState<SearchAppBarState> = mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")
    private val _allTasks = MutableStateFlow<List<TodoTask>>(emptyList())
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