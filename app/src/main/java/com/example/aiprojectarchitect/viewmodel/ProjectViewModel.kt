package com.example.aiprojectarchitect.viewmodel

import androidx.lifecycle.ViewModel
import com.example.aiprojectarchitect.firebase.FirestoreManager
import com.example.aiprojectarchitect.model.Project
import com.example.aiprojectarchitect.repository.ProjectRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProjectViewModel : ViewModel() {

    private val repository =
        ProjectRepository(FirestoreManager())

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

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
}