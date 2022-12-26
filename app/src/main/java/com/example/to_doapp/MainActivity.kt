package com.example.to_doapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.to_doapp.navigation.SetupNavigation
import com.example.to_doapp.ui.theme.ToDoAppTheme
import com.example.to_doapp.ui.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // this function get from Theme in ui theme
            ToDoAppTheme {
                // A surface container using the 'background' color from the theme
                navController = rememberNavController()
                SetupNavigation(navController = navController, sharedViewModel=sharedViewModel)
            }
        }
    }
}
