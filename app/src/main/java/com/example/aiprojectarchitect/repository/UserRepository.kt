package com.example.aiprojectarchitect.repository

import FirestoreManager

class UserRepository(
    private val firestoreManager: FirestoreManager

){

    fun saveUser(
        uid: String,
        email: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        firestoreManager.saveUser(
            uid = uid,
            email = email,
            onSuccess = onSuccess,
            onError = onFailure
        )
    }
}