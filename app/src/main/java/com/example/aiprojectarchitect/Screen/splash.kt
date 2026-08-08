package com.example.aiprojectarchitect.Screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.aiprojectarchitect.viewmodel.AuthViewModel
import kotlinx.coroutines.delay
@Composable
fun splash(navController: NavController){

    val authViewModel: AuthViewModel = viewModel()

    LaunchedEffect(Unit) {

        delay(2000)

        if (authViewModel.isUserLoggedIn()) {

            navController.navigate("home") {
                popUpTo("splash") {
                    inclusive = true
                }
            }

        } else {

            navController.navigate("login") {
                popUpTo("splash") {
                    inclusive = true
                }
            }
        }
    }

}
