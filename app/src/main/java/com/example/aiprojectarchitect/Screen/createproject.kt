package com.example.aiprojectarchitect.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aiprojectarchitect.viewmodel.ProjectViewModel

@Composable
fun create() {

    val projectViewModel: ProjectViewModel = viewModel()

    val prompt by projectViewModel.currentPrompt.collectAsState()
    val response by projectViewModel.generatedResponse.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "AI Project Blueprint",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Your Project",
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = prompt,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Architecture",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = response ?: "Generating architecture...",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}