package com.example.to_doapp.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.to_doapp.ui.screens.list.ListScreen
import com.example.to_doapp.ui.viewmodels.SharedViewModel
import com.example.to_doapp.util.Constants.LIST_ARGUMENT_KEY
import com.example.to_doapp.util.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    // this will pass the navigate to task screen function
    navigateToTaskScreen: (taskId: Int) -> Unit,
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(navigateToTaskScreen = navigateToTaskScreen)
    }
}