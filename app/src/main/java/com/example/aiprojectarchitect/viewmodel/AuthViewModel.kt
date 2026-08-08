package com.example.aiprojectarchitect.viewmodel

import FirestoreManager
import androidx.lifecycle.ViewModel
import com.example.aiprojectarchitect.firebase.FirebaseAuthManager
import com.example.aiprojectarchitect.repository.AuthRepository
import com.example.aiprojectarchitect.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {

    private val repository =
        AuthRepository(FirebaseAuthManager())

    private val userRepository =
        UserRepository(FirestoreManager())

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error


    fun isUserLoggedIn(): Boolean {
        return repository.getCurrentUser() != null
    }
    fun signUp(
        email: String,
        password: String,
        onSuccess: (String) -> Unit
    ) {

        _isLoading.value = true
        _error.value = null

        repository.signUp(
            email = email,
            password = password,

            onSuccess = { uid ->

                userRepository.saveUser(
                    uid = uid,
                    email = email,

                    onSuccess = {
                        _isLoading.value = false
                        onSuccess(uid)
                    },

                    onFailure = { message ->
                        _isLoading.value = false
                        _error.value = message
                    }
                )
            },

            onFailure = { message ->
                _isLoading.value = false
                _error.value = message
            }
        )
    }

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit
    ) {

        _isLoading.value = true
        _error.value = null

        repository.login(
            email = email,
            password = password,

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

    fun logout(){
        repository.logout()
    }
}