package com.example.aiprojectarchitect.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun signup(navController: NavController){

    var email by remember{ mutableStateOf("") }

    var password by remember{ mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize() ,
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            text = "SignUp",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(value = email , onValueChange = {email = it} ,
            label = {
                Text("Email")
            })

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },

            visualTransformation = if (passwordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),

            trailingIcon = {
                IconButton(onClick = {
                    passwordVisible = !passwordVisible
                }) {
                    Icon(
                        imageVector = if (passwordVisible)
                            Icons.Default.Favorite
                        else
                            Icons.Default.Favorite,
                        contentDescription = null
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(13.dp))

        Button(onClick = {navController.navigate("home"){
            popUpTo("signup"){
                inclusive = true
            }
        } }) {

            Text("LogIn")
        }

        Spacer(modifier = Modifier.height(11.dp))

        TextButton(onClick = {navController.navigate("login")}) {

            Text("Already have an account?")
        }

    }
}