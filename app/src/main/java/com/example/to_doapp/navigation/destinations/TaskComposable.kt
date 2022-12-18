package com.example.to_doapp.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_doapp.util.Action
import com.example.to_doapp.util.Constants.TASK_ARGUMENT_KEY
import com.example.to_doapp.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    // this will pass the navigate to task screen function
    navigateToListScreen: (Action) -> Unit,
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {

    }
}