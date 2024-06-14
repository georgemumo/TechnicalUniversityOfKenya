package com.apk.george.ui.theme.screens.login

//import AuthViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
//import com.apk.george.R
//import com.apk.george.data.AuthViewModel
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_REGISTER


@Composable
fun LoginScreen(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
       Box {
            Image(painter = painterResource(id = R.drawable.logo1), contentDescription ="" )
        }
        var password by remember { mutableStateOf(TextFieldValue("")) }
        var context= LocalContext.current
        var isChecked by remember { mutableStateOf(false) }
        var email by remember { mutableStateOf(TextFieldValue("")) }
        Text(text = "Log in",
            fontSize = 33.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email, onValueChange = {email=it},
            placeholder = { Text(text = "Enter your email") },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") }

        )
        Spacer(modifier = Modifier.height(20.dp))
//        var passwordVisibility by remember { mutableStateOf(false) }
//        var password by rememberSaveable{ mutableStateOf( TextFieldValue("")) }
//        val icon = if (passwordVisibility)
//            painterResource(id = R.drawable.design_ic_visibility)
//        else
//            painterResource(id = R.drawable.design_ic_visibility_off)
//
//        OutlinedTextField(
//            modifier = Modifier.fillMaxWidth(),
//            value =password ,
//            onValueChange ={
//                password = it
//            },
//            placeholder = { Text(text = "Enter your password") },
//            label = { Text(text = "Password") },
//            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "") },
//            trailingIcon = {
//                IconButton(onClick = {
//                    passwordVisibility = !passwordVisibility
//                }) {
//                    Icon(
//                        painter = icon,
//                        contentDescription = "Visibility Icon"
//                    )
//                }
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Password
//            ),
//            visualTransformation = if (passwordVisibility) VisualTransformation.None
//            else PasswordVisualTransformation()
//        )
//        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value =password , onValueChange = {password=it},
            label = { Text(text = "Enter password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Spacer(modifier = Modifier.height(20.dp))
//        Button(onClick = {
//            val mylogin= AuthViewModel(navController, context )
//            mylogin.logIn(email.text.trim(),password.text.trim())
//            navController.navigate(ROUTE_HOME)
//        }, modifier = Modifier.fillMaxWidth()) {
//            Text(text = "Log In")
//        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate(ROUTE_REGISTER)}) {
            Text(text = "Don't have an account?Click to create one")
        }

    }
}
@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())

}