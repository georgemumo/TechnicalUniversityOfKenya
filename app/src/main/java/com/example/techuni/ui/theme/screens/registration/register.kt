package com.apk.george.ui.theme.screens.registration

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.techuni.R
import com.example.techuni.data.AuthViewModel
//import com.apk.george.data.AutViewModel
import com.example.techuni.navigation.ROUTE_LOGIN

//import com.example.tech.R

@Composable
fun RegistrationScreen(navController: NavController){


    Column (modifier = Modifier
        .padding(16.dp)
        .background(color = Color.White)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.Center

    ){
        Image(painter = painterResource(id = R.drawable.logo1), contentDescription = "",)
        Spacer(modifier = Modifier.height(20.dp))

        var email by remember {  mutableStateOf("")   }
        var password by remember {      mutableStateOf("")  }
        var confirmPassword by remember { mutableStateOf("") }
        var name by remember {     mutableStateOf("") }
        val context = LocalContext.current
        val focusManager= LocalFocusManager.current

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            placeholder = { Text(text = "Enter your name")},

            singleLine = true,


            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value =email,
            onValueChange ={email=it}
            , singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "")},
            label = { Text(text = "Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                , modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )


        var isChecked by remember {      mutableStateOf(false)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Checkbox(checked = isChecked, onCheckedChange = {isChecked=it},
                enabled = true,
                modifier = Modifier
                    .padding(5.dp)
                    .size(3.dp)
                , colors = CheckboxDefaults.colors()
            )
            Spacer(modifier = Modifier.padding(6.dp))
            Text(text = "I agree to the terms & conditions")
        }
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(visible = email.isNotBlank() && password.isNotBlank() &&confirmPassword.isNotBlank() &&name.isNotBlank() ) {
            Button(
                onClick = {
                    val authViewModel = AuthViewModel(navController, context)
                    authViewModel.signUp(email.trim(), password.trim(), confirmPassword.trim(),name.trim())
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary
                )
            ) {
                Text(text = "Register")
            }
        }
        TextButton(onClick = { navController.navigate(ROUTE_LOGIN) }) {
            Text(
                text = "Already have an account? Click to login ",
//                TextDecoration=TextDecoration.Underline,
             color = Color.Blue,

            )
        }

        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Preview
@Composable
fun RegistrationScreenPreview(){
    RegistrationScreen(rememberNavController())
}