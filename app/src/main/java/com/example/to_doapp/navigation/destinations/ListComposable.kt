package com.example.to_doapp.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navArgument
import com.example.to_doapp.ui.screens.list.ListScreen
import com.example.to_doapp.ui.viewmodels.SharedViewModel
import com.example.to_doapp.util.Constants.LIST_ARGUMENT_KEY
import com.example.to_doapp.util.Constants.LIST_SCREEN
import com.example.to_doapp.util.toAction

@ExperimentalMaterialApi
@ExperimentalAnimationApi
fun NavGraphBuilder.listComposable(
    // this will pass the navigate to task screen function
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {

    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        LaunchedEffect(key1 = action) {
            sharedViewModel.action.value = action
        }

        val databaseAction by sharedViewModel.action

        ListScreen(navigateToTaskScreen = navigateToTaskScreen, sharedViewModel = sharedViewModel, action=databaseAction)
    }
}