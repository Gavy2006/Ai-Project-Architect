package com.example.aiprojectarchitect.firebase

import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthManager {

    private val auth = FirebaseAuth.getInstance()

    val currentUser
        get() = auth.currentUser

    fun signUp(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { exception ->
                onError(exception.message ?: "SignUp Failed")
            }
    }


    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { exception ->
                onError(exception.message ?: "Login Failed")
            }
    }

    fun logout() {
        auth.signOut()
    }
}