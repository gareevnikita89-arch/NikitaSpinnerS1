package com.nikita.spinners1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = TextView(this).apply {
            text = "Nikita Spinner S1 v1.0\nРаботает!"
            textSize = 24f
            setPadding(50, 50, 50, 50)
        }
        setContentView(view)
    }
}

