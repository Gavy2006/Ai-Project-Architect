package com.example.aiprojectarchitect.Screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomBar(navController: NavController) {

    NavigationBar {

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate("home") {
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(Icons.Default.Home, contentDescription = "home")
            },
            label = {
                Text("home")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate("create"){
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(Icons.Default.Home, contentDescription = "create")
            },
            label = {
                Text(" create")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate("history"){
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(Icons.Default.CheckCircle, contentDescription = "history")
            },
            label = {
                Text("history")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate("profile"){
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(Icons.Default.Person, contentDescription = "profile")
            },
            label = {
                Text("Profile")
            }
        )

    }
}