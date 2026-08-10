
package com.example.aiprojectarchitect.components

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aiprojectarchitect.viewmodel.ProjectViewModel
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.example.aiprojectarchitect.Screen.BottomBar
import com.example.aiprojectarchitect.Screen.TopBar
import com.example.aiprojectarchitect.Screen.create
import com.example.aiprojectarchitect.Screen.history
import com.example.aiprojectarchitect.Screen.home
import com.example.aiprojectarchitect.Screen.login
import com.example.aiprojectarchitect.Screen.profile
import com.example.aiprojectarchitect.Screen.signup
import com.example.aiprojectarchitect.Screen.splash
@Composable
fun navigation() {



        val navController = rememberNavController()

        val projectViewModel: ProjectViewModel = viewModel()

        val currentRoute =
            navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(

        topBar = {
            if (currentRoute !in listOf ("splash", "login", "signup")) {
            TopBar()
         }
        } ,

        bottomBar = {
            if (currentRoute !in listOf("splash", "login", "signup")) {
                BottomBar(navController)
            }
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "splash",
            modifier = Modifier.padding(padding)
        ) {

            composable("splash") {
                splash(navController)
            }

            composable("signup") {
                signup(navController)
            }

            composable("login") {
                login(navController)
            }

            composable("home") {
                home(
                    navController = navController,
                    projectViewModel = projectViewModel
                )
            }

            composable("create") {
                create(projectViewModel)
            }

            composable("history") {
                history()
            }

            composable("profile") {
                profile(navController)
            }
        }
    }
}

