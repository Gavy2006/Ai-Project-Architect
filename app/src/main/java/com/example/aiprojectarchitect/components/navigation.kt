package com.example.aiprojectarchitect.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aiprojectarchitect.Screen.create
import com.example.aiprojectarchitect.Screen.history
import com.example.aiprojectarchitect.Screen.home
import com.example.aiprojectarchitect.Screen.login
import com.example.aiprojectarchitect.Screen.profile
import com.example.aiprojectarchitect.Screen.signup
import com.example.aiprojectarchitect.Screen.splash
import kotlin.math.sign
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import com.example.aiprojectarchitect.Screen.BottomBar
import com.example.aiprojectarchitect.Screen.TopBar

@Composable
fun navigation() {

    val navController = rememberNavController()

    Scaffold(

        topBar = {
            TopBar()
        },

        bottomBar = {
            BottomBar()
        }

    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "splash",
            modifier = Modifier.padding(padding)
        ) {

            composable("splash") {
                splash()
            }

            composable("signup") {
                signup()
            }

            composable("login") {
                login()
            }

            composable("home") {
                home()
            }

            composable("create") {
                create()
            }

            composable("history") {
                history()
            }

            composable("profile") {
                profile()
            }
        }
    }
}