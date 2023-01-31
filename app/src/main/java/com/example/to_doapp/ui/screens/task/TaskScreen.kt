package com.example.to_doapp.ui.screens.task

import android.content.Context
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.example.to_doapp.data.models.Priority
import com.example.to_doapp.data.models.ToDoTask
import com.example.to_doapp.ui.viewmodels.SharedViewModel
import com.example.to_doapp.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    val context = LocalContext.current

    BackHandler(onBackPressed = { navigateToListScreen(Action.NO_ACTION) })

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = { action ->
                    // if we just press back button
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen(action)
                    // if we press other actions in navbar
                    } else {
                        if (sharedViewModel.validateFields()) {
                            navigateToListScreen(action)
                        } else {
                            // apply to both add new task and update task
                            displayToast(context = context)
                        }
                    }
                }
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = { sharedViewModel.updateTitle(it) },
                description = description,
                onDescriptionChange = { sharedViewModel.description.value = it },
                priority = priority,
                onPrioritySelected = { sharedViewModel.priority.value = it }
            )
        }
    )
}

fun displayToast(context: Context) {
    Toast.makeText(context, "Fields Empty.", Toast.LENGTH_SHORT).show()
}

@Composable
fun BackHandler(
    backDispatcher: OnBackPressedDispatcher? = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher,
    onBackPressed: () -> Unit
) {
    // will save update onBackPressed lambda when new one is provided
    val currentOnBackPressed by rememberUpdatedState(newValue = onBackPressed)
    val backCallback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                currentOnBackPressed()
            }
        }
    }
    // call when key changes or composable function leaves composation
    DisposableEffect(key1 = backDispatcher) {
        // add new callback and remove old one
        backDispatcher?.addCallback(backCallback)
        onDispose { backCallback.remove() }
    }
}

