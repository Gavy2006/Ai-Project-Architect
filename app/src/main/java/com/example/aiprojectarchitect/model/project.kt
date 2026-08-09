package com.example.aiprojectarchitect.model


data class Project(
    val id: String = "",
    val userId: String = "",
    val title: String = "",
    val description: String = "",
    val techStack: List<String> = emptyList(),
    val createdAt: Long = 0L
)