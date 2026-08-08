package com.example.aiprojectarchitect.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.aiprojectarchitect.viewmodel.AuthViewModel

@Composable
fun profile(navController: NavController) {

    val authViewModel: AuthViewModel = viewModel()

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("profile Screen")

        Button(
            onClick = {

                authViewModel.logout()

                navController.navigate("login") {
                    popUpTo("home") {
                        inclusive = true
                    }
                }
            }
        ) {
            Text("log out")
        }
    }
}