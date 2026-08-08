package com.example.aiprojectarchitect.repository

import com.example.aiprojectarchitect.firebase.FirebaseAuthManager

class AuthRepository(
    private val authManager: FirebaseAuthManager
) {

    fun signUp(
        email: String,
        password: String,
        onSuccess: (String) -> Unit,
        onFailure: (String) -> Unit
    ) {

        authManager.signUp(
            email,
            password,
            onSuccess,
            onFailure
        )
    }

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {

        authManager.login(
            email,
            password,
            onSuccess,
            onFailure
        )
    }

    fun logout() {
        authManager.logout()
    }

    fun getCurrentUser() = authManager.currentUser
}