package com.example.first_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val btn_1: Button = findViewById(R.id.btn_1)
        btn_1.setOnClickListener {
            val intent_1 = Intent(this, Login_Page::class.java)
            startActivity(intent_1)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        val btn_2 : Button = findViewById(R.id.btn_2)
        btn_2.setOnClickListener {
            val intent_2 = Intent(this, Register_Page::class.java)
            startActivity(intent_2)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }




    }

}
