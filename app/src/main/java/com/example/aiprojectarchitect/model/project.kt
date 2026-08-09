package com.example.aiprojectarchitect.model


data class Project(
    val id: String = "",
    val userId: String = "",
    val prompt: String = "",
    val title: String = "",
    val aiResponse: String = "",
    val createdAt: Long = 0L
)