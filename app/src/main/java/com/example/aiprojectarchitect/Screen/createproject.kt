package com.example.aiprojectarchitect.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aiprojectarchitect.viewmodel.ProjectViewModel

@Composable
fun create(projectViewModel: ProjectViewModel) {

    val prompt by projectViewModel.currentPrompt.collectAsState()
    val response by projectViewModel.generatedResponse.collectAsState()

    val sections = parseArchitecture(response)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = 18.dp,
                end = 18.dp,
                top = 20.dp,
                bottom = 32.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // ------------------------------------------------
            // HEADER
            // ------------------------------------------------

            item {

                Column {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column {

                            Text(
                                text = "PROJECT BLUEPRINT",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = "Your architecture is ready",
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Surface(
                            modifier = Modifier.size(46.dp),
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primaryContainer
                        ) {

                            Box(
                                contentAlignment = Alignment.Center
                            ) {

                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(
                            containerColor =
                                MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {

                            Text(
                                text = "AI ARCHITECT",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = prompt.ifBlank {
                                    "Untitled Project"
                                },
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = "Implementation-ready software blueprint generated from your idea.",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }

            // ------------------------------------------------
            // STATS
            // ------------------------------------------------

            item {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    StatCard(
                        modifier = Modifier.weight(1f),
                        value = sections.size.toString(),
                        label = "Sections"
                    )

                    StatCard(
                        modifier = Modifier.weight(1f),
                        value = "AI",
                        label = "Analysis"
                    )

                    StatCard(
                        modifier = Modifier.weight(1f),
                        value = "Ready",
                        label = "Blueprint"
                    )
                }
            }

            // ------------------------------------------------
            // PROJECT OVERVIEW
            // ------------------------------------------------

            sections["PROJECT_OVERVIEW"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Project Overview",
                        subtitle = "What you're building",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // REQUIREMENTS
            // ------------------------------------------------

            sections["REQUIREMENTS"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Requirements",
                        subtitle = "Functional and non-functional needs",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // USER ROLES
            // ------------------------------------------------

            sections["USER_ROLES"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "User Roles",
                        subtitle = "Who interacts with the system",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // CORE MODULES
            // ------------------------------------------------

            sections["CORE_MODULES"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Core Modules",
                        subtitle = "Major product capabilities",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // SYSTEM ARCHITECTURE
            // ------------------------------------------------

            sections["SYSTEM_ARCHITECTURE"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "System Architecture",
                        subtitle = "How the complete system works",
                        icon = Icons.Default.CheckCircle,
                        content = content,
                        highlighted = true
                    )
                }
            }

            // ------------------------------------------------
            // ARCHITECTURE PATTERN
            // ------------------------------------------------

            sections["ARCHITECTURE_PATTERN"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Architecture Pattern",
                        subtitle = "Recommended engineering structure",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // TECH STACK
            // ------------------------------------------------

            sections["TECH_STACK"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Technology Stack",
                        subtitle = "Recommended technologies",
                        icon = Icons.Default.CheckCircle,
                        content = content,
                        highlighted = true
                    )
                }
            }

            // ------------------------------------------------
            // DATABASE
            // ------------------------------------------------

            sections["DATABASE"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Database Design",
                        subtitle = "Data model and relationships",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // API DESIGN
            // ------------------------------------------------

            sections["API_DESIGN"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "API Design",
                        subtitle = "Backend communication layer",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // AI ARCHITECTURE
            // ------------------------------------------------

            sections["AI_ARCHITECTURE"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "AI Architecture",
                        subtitle = "Where AI adds genuine value",
                        icon = Icons.Default.CheckCircle,
                        content = content,
                        highlighted = true
                    )
                }
            }

            // ------------------------------------------------
            // DATA FLOW
            // ------------------------------------------------

            sections["DATA_FLOW"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Data Flow",
                        subtitle = "How information moves through the system",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // DIAGRAM
            // ------------------------------------------------

            sections["DIAGRAM"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Architecture Diagram",
                        subtitle = "Visual architecture specification",
                        icon = Icons.Default.CheckCircle,
                        content = content,
                        highlighted = true
                    )
                }
            }

            // ------------------------------------------------
            // ROADMAP
            // ------------------------------------------------

            sections["ROADMAP"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Development Roadmap",
                        subtitle = "Build the product step by step",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // TASKS
            // ------------------------------------------------

            sections["TASKS"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Development Tasks",
                        subtitle = "Actionable implementation plan",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // TESTING
            // ------------------------------------------------

            sections["TESTING"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Testing Strategy",
                        subtitle = "Quality and reliability",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // SCALABILITY
            // ------------------------------------------------

            sections["SCALABILITY"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Scalability",
                        subtitle = "How the system grows",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // OBSERVABILITY
            // ------------------------------------------------

            sections["OBSERVABILITY"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Observability",
                        subtitle = "Monitoring and system health",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // RISKS
            // ------------------------------------------------

            sections["RISKS"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Risks & Mitigation",
                        subtitle = "What can go wrong",
                        icon = Icons.Default.Warning,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // MVP
            // ------------------------------------------------

            sections["MVP"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "MVP & Future",
                        subtitle = "What to build now vs later",
                        icon = Icons.Default.CheckCircle,
                        content = content
                    )
                }
            }

            // ------------------------------------------------
            // FINAL RECOMMENDATION
            // ------------------------------------------------

            sections["FINAL_RECOMMENDATION"]?.let { content ->

                item {

                    BlueprintCard(
                        title = "Architect's Recommendation",
                        subtitle = "Final technical direction",
                        icon = Icons.Default.CheckCircle,
                        content = content,
                        highlighted = true
                    )
                }
            }

            // ------------------------------------------------
            // FALLBACK
            // ------------------------------------------------

            if (sections.isEmpty()) {

                item {

                    BlueprintCard(
                        title = "AI Architecture",
                        subtitle = "Generated architecture",
                        icon = Icons.Default.CheckCircle,
                        content = response
                            ?: "Generating architecture..."
                    )
                }
            }
        }
    }
}


/* ========================================================= */
/* BLUEPRINT CARD */
/* ========================================================= */

@Composable
private fun BlueprintCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    content: String,
    highlighted: Boolean = false
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                if (highlighted) {
                    MaterialTheme.colorScheme.primaryContainer
                } else {
                    MaterialTheme.colorScheme.surface
                }
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    modifier = Modifier.size(42.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {

                    Box(
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.width(12.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            HorizontalDivider()

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Text(
                text = cleanContent(content),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}


/* ========================================================= */
/* STAT CARD */
/* ========================================================= */

@Composable
private fun StatCard(
    modifier: Modifier,
    value: String,
    label: String
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(14.dp)
        ) {

            Text(
                text = value,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}


/* ========================================================= */
/* PARSER */
/* ========================================================= */

private fun parseArchitecture(
    response: String?
): Map<String, String> {

    if (response.isNullOrBlank()) {
        return emptyMap()
    }

    val result = mutableMapOf<String, String>()

    val regex = Regex(
        """\[(\w+)]\s*(.*?)\s*\[/\1]""",
        setOf(
            RegexOption.DOT_MATCHES_ALL,
            RegexOption.IGNORE_CASE
        )
    )

    regex.findAll(response).forEach { match ->

        val sectionName =
            match.groupValues[1].uppercase()

        val sectionContent =
            match.groupValues[2].trim()

        if (sectionContent.isNotBlank()) {

            result[sectionName] =
                sectionContent
        }
    }

    return result
}


/* ========================================================= */
/* CLEAN RESPONSE */
/* ========================================================= */

private fun cleanContent(
    text: String
): String {

    return text
        .replace("###", "")
        .replace("**", "")
        .replace("```", "")
        .trim()
}