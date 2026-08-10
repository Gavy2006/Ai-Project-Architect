package com.example.aiprojectarchitect.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aiprojectarchitect.ai.GeminiService
import com.example.aiprojectarchitect.ai.PromptBuilder
import com.example.aiprojectarchitect.firebase.FirestoreManager
import com.example.aiprojectarchitect.model.Project
import com.example.aiprojectarchitect.repository.ProjectRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProjectViewModel : ViewModel() {

    private val repository =
        ProjectRepository(FirestoreManager())

    private val generate = GeminiService()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error


    private val _generatedResponse = MutableStateFlow<String?>(null)
    val generatedResponse: StateFlow<String?> = _generatedResponse

    private val _currentPrompt = MutableStateFlow("")
    val currentPrompt: StateFlow<String> = _currentPrompt

    fun saveProject(
        project: Project,
        onSuccess: () -> Unit
    ) {

        _isLoading.value = true
        _error.value = null

        repository.saveProject(
            project = project,

            onSuccess = {
                _isLoading.value = false
                onSuccess()
            },

            onFailure = { message ->
                _isLoading.value = false
                _error.value = message
            }
        )
    }


    fun generateArchitecture(
        prompt: String,
        onSuccess: (String) -> Unit
    ) {

        _isLoading.value = true
        _error.value = null

        viewModelScope.launch {

            try {

                println("USER PROMPT: $prompt")

                val architecturePrompt =
                    PromptBuilder.buildArchitecturePrompt(prompt)

                println("ARCHITECT PROMPT CREATED")

                val response =
                    generate.generateArchitecture(architecturePrompt)

                println("GEMINI RESPONSE: $response")

                _currentPrompt.value = prompt
                _generatedResponse.value = response

                _isLoading.value = false
                onSuccess(response)

            } catch (exception: Exception) {

                _isLoading.value = false

                _error.value =
                    exception.message
                        ?: "Failed to generate architecture"

                println(
                    "GEMINI ERROR: ${exception.message}"
                )
            }
        }
    }
}