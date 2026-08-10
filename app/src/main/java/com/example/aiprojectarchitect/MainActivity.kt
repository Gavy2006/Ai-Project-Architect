package com.example.aiprojectarchitect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.material3.Text
import com.example.aiprojectarchitect.components.navigation

import com.google.firebase.Firebase
import com.google.firebase.appcheck.appCheck
import com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory

import com.example.aiprojectarchitect.ui.theme.AiProjectArchitectTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Firebase.appCheck.installAppCheckProviderFactory(
            DebugAppCheckProviderFactory.getInstance()
        )

        enableEdgeToEdge()

        setContent {
            AiProjectArchitectTheme {
                navigation()
            }
        }


    }
}