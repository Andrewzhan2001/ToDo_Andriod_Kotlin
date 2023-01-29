package com.example.to_doapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.to_doapp.navigation.destinations.listComposable
import com.example.to_doapp.navigation.destinations.splashComposable
import com.example.to_doapp.navigation.destinations.taskComposable
import com.example.to_doapp.ui.viewmodels.SharedViewModel
import com.example.to_doapp.util.Constants.SPLASH_SCREEN
import com.google.accompanist.navigation.animation.AnimatedNavHost


@Composable
@ExperimentalMaterialApi
@ExperimentalAnimationApi
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
){
    val screen = remember(navController) {
        // we want to remember the screen throughout the application
        // contains all navigate function
        Screens(navController = navController)
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        splashComposable(
            navigateToListScreen = screen.splash
        )
        listComposable(
            navigateToTaskScreen = screen.task,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screen.list,
            sharedViewModel = sharedViewModel
        )
    }
}