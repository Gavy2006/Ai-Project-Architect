package com.example.aiprojectarchitect.Screen

import com.example.aiprojectarchitect.components.ProjectCardData
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.aiprojectarchitect.components.QuickTemplateList
import com.example.aiprojectarchitect.components.RecentProjectList
import com.example.aiprojectarchitect.viewmodel.ProjectViewModel


@Composable
fun home(navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ){

        item {
            Header()
        }

        item {
            PromptSection(navController)
        }

        item {
            bottom()
        }
    }
}


@Composable
fun Header() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 24.dp)
    ) {

        Spacer(modifier = Modifier.height(4.dp))


        Text(
            text = "👋 Hello Gavy",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Describe your idea and let AI generate a complete software architecture in seconds.",
            fontSize = 15.sp,
            color = Color.Gray,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
            shape = RoundedCornerShape(18.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.width(14.dp))

                Column {

                    Text(
                        text = "AI Powered",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "Architecture • Database • API • Roadmap",
                        color = Color.Gray,
                        fontSize = 13.sp
                    )
                }
            }
        }
    }
}




@Composable
fun bottom() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "Quick Templates",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(QuickTemplateList) { project ->

                QuickTemplateCard(project)

            }

        }

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            "Recent Projects",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            RecentProjectList.forEach { project ->

                ProjectCard(project)

            }

        }
    }
}


@Composable
fun ProjectCard(project: ProjectCardData) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Card(
                shape = RoundedCornerShape(12.dp)
            ) {

                Box(
                    modifier = Modifier
                        .size(50.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = project.icon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = project.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = project.description,
                    fontSize = 13.sp,
                    color = Color.Gray,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Last opened • Today",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            IconButton(
                onClick = { }
            ) {

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null
                )

            }
        }
    }
}

@Composable
fun QuickTemplateCard(project: ProjectCardData) {

    Card(
        modifier = Modifier
            .width(165.dp)
            .height(150.dp),
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Icon(
                imageVector = project.icon,
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = MaterialTheme.colorScheme.primary
            )

            Column {

                Text(
                    text = project.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

            }

            Text(
                text = "Generate →",
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}


@Composable
fun PromptSection(
    navController: NavController
) {

    var prompt by remember {
        mutableStateOf("")
    }

    val projectViewModel: ProjectViewModel = viewModel()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Describe Your Project",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = prompt,

            onValueChange = {
                prompt = it
            },

            modifier = Modifier.fillMaxWidth(),

            placeholder = {
                Text(
                    "Describe your project idea..."
                )
            },

            minLines = 5,
            maxLines = 8
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {

                projectViewModel.generateArchitecture(
                    prompt = prompt,

                    onSuccess = { response ->

                        projectViewModel.saveProject(
                            project = com.example.aiprojectarchitect.model.Project(
                                userId = "",
                                prompt = prompt,
                                title = "New Project",
                                aiResponse = response,
                                createdAt = System.currentTimeMillis()
                            ),

                            onSuccess = {

                                // Gemini response successfully generated
                                // and project saved.

                                navController.navigate("create")
                            }
                        )
                    }
                )
            },

            modifier = Modifier.fillMaxWidth(),

            enabled = prompt.isNotBlank()
        ) {

            Text(
                text = "Generate Architecture"
            )
        }
    }
}