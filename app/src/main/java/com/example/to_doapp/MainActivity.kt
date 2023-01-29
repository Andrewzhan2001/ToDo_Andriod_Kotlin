package com.example.to_doapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController
import com.example.to_doapp.navigation.SetupNavigation
import com.example.to_doapp.ui.theme.ToDoAppTheme
import com.example.to_doapp.ui.viewmodels.SharedViewModel
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalMaterialApi
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // this function get from Theme in ui theme
            ToDoAppTheme {
                // A surface container using the 'background' color from the theme
                navController = rememberAnimatedNavController()
                SetupNavigation(navController = navController, sharedViewModel=sharedViewModel)
            }
        }
    }
}
