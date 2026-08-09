package com.example.aiprojectarchitect.repository

import com.example.aiprojectarchitect.firebase.FirestoreManager
import com.example.aiprojectarchitect.model.Project

class ProjectRepository(
    private val firestoreManager: FirestoreManager
) {

    fun saveProject(
        project: Project,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {

        firestoreManager.saveProject(
            project = project,
            onSuccess = onSuccess,
            onError = onFailure
        )
    }
}