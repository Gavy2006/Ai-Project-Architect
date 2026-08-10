package com.example.aiprojectarchitect.ai

import com.google.firebase.Firebase
import com.google.firebase.ai.GenerativeModel
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend

class GeminiService {

    private val model: GenerativeModel =
        Firebase.ai(
            backend = GenerativeBackend.googleAI()
        ).generativeModel("gemini-3.5-flash-lite")

    suspend fun generateArchitecture(
        prompt: String
    ): String {

        val response = model.generateContent(prompt)

        return response.text ?: "No response generated"
    }
}