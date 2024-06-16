package com.example.techuni.data

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.apk.george.models.User
import com.example.techuni.navigation.ROUTE_HOME
import com.example.techuni.navigation.ROUTE_LOGIN
import com.example.techuni.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(private val navController: NavController, private val context: Context) : ViewModel(){

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val loading : MutableState<Boolean> = mutableStateOf(false)

    fun signUp(email: String, password: String, confirmPassword: String, trim: String) {
        if (!isValidEmail(email)) {
            showToast("Invalid email format")
            return
        }

        if (!isValidPassword(password)) {
            showToast("Password must be at least 6 characters long")
            return
        }

        if (password != confirmPassword) {
            showToast("Passwords do not match")
            return
        }

        loading.value = true
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                loading.value = false
                if (task.isSuccessful) {
                    saveUserData(email, password,confirmPassword)
                    navController.navigate(ROUTE_HOME)
                } else {
                    handleAuthError(task.exception?.message ?: "Unknown error")
                }
            }
    }

    fun logIn(email: String, password: String) {
        loading.value = true
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                loading.value = false
                if (task.isSuccessful) {
                    navController.navigate(ROUTE_HOME)
                } else {
                    handleAuthError(task.exception?.message ?: "Unknown error")
                }
            }
    }

    fun logOut() {
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }
    private fun isValidEmail(email: String): Boolean {
        // Basic email validation
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun saveUserData(email: String, confirmPassword: String,password: String) {
        val userData = User(email,password,confirmPassword , mAuth.currentUser!!.uid)
        val regRef = FirebaseDatabase.getInstance().getReference()
            .child("Users/${mAuth.currentUser!!.uid}")

        regRef.setValue(userData)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    showToast("Registered successfully")
                    navController.navigate(ROUTE_HOME)
                } else {
                    handleAuthError(task.exception?.message ?: "Unknown error")
                }
            }
    }
    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun handleAuthError(errorMessage: String) {
        showToast(errorMessage)
        navController.navigate(ROUTE_REGISTER)
    }
    private fun isValidPassword(password: String): Boolean {
        val hasLetters = password.any { it.isLetter() }
        val hasNumbers = password.any { it.isDigit() }
        val hasSymbols = password.any { !it.isLetterOrDigit() }
        return hasLetters && hasNumbers
    }



}