package com.example.to_doapp.navigation.destinations

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.to_doapp.ui.screens.list.ListScreen
import com.example.to_doapp.ui.viewmodels.SharedViewModel
import com.example.to_doapp.util.Constants.LIST_ARGUMENT_KEY
import com.example.to_doapp.util.Constants.LIST_SCREEN
import com.example.to_doapp.util.toAction

@ExperimentalMaterialApi
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

        ListScreen(navigateToTaskScreen = navigateToTaskScreen, sharedViewModel = sharedViewModel)
    }
}