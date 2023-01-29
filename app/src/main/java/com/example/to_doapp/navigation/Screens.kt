package com.example.to_doapp.navigation
import android.util.Log
import androidx.navigation.NavHostController
import com.example.to_doapp.util.Action
import com.example.to_doapp.util.Constants.LIST_SCREEN
import com.example.to_doapp.util.Constants.SPLASH_SCREEN


class Screens(navController: NavHostController) {
    // will used to navigate from splash screen to list screen
    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION}") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }
    val list: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    // when we go from List to Task screen we do not want to pop off the List screen and keep it in the stack
    val task: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
}