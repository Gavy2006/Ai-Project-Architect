package com.example.aiprojectarchitect.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.ui.res.painterResource

val RecentProjectList = listOf(
    Project(
        Icons.Default.Person,
        "AI Chatbot",
        "A chatbot using Gemini API"
    ),
    Project(
        Icons.Default.Person,
        "Expense Tracker",
        "Track daily expenses"
    ),
    Project(
        Icons.Default.Person,
        "Weather App",
        "Shows live weather updates"
    )
)