package com.example.techuni.ui.theme.screens.notices

import androidx.activity.ComponentActivity
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
//import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContract
import java.util.*

class DatePickerActivity : ComponentActivity() {

    companion object {
        fun newIntent(context: Context, initialDate: Date): Intent {
            return Intent(context, DatePickerActivity::class.java).apply {
                putExtra("initialDate", initialDate)
            }
        }
    }

    private lateinit var initialDate: Date

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialDate = intent.getSerializableExtra("initialDate") as Date

        // Implement your date picker logic here
        // You can use DatePickerDialog or any other date picker library
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        super.onBackPressed()
    }

    // Return selected date to calling activity
    private fun returnSelectedDate(selectedDate: Date) {
        val resultIntent = Intent().apply {
            putExtra("selectedDate", selectedDate)
        }
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}
