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

@Composable
fun BottomBar() {

    NavigationBar {

        NavigationBarItem(
            selected = false,
            onClick = {

            },
            icon = {
                Icon(Icons.Default.Home, contentDescription = "create")
            },
            label = {
                Text("new project")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {

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