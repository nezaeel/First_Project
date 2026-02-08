package com.example.first_project

import android.content.Intent
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.text.Editable





class Login_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn_back_Login: ImageView = findViewById(R.id.btn_back_Login)
        btn_back_Login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        val txt_Form_Login_To_Register: TextView = findViewById(R.id.txt_Form_Login_To_Register)
        txt_Form_Login_To_Register.setOnClickListener {
            val register = Intent(this, Register_Page::class.java)
            startActivity(register)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        val inputText: EditText = findViewById(R.id.et_L_1)
        val btnSend: Button = findViewById(R.id.btn_L_1)

        btnSend.setOnClickListener {
            val text = inputText.text.toString()


            val username = Intent(this, After_Login::class.java)
            username.putExtra("text_key", text)
            startActivity(username)
        }

        val editPassword: EditText = findViewById(R.id.et_L_2)
        val btnLogin: Button = findViewById(R.id.btn_L_1)

        btnLogin.isEnabled = false
        btnLogin.alpha = 0.5f // efek tombol nonaktif

        val watcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val password = editPassword.text.toString().trim()



                if (password.isEmpty()) {
                    editPassword.error = "Password tidak boleh kosong"
                } else {
                    editPassword.error = null
                }

                val isFilled = password.isNotEmpty()
                btnLogin.isEnabled = isFilled
                btnLogin.alpha = if (isFilled) 1f else 0.5f

            }

            override fun afterTextChanged(s: Editable?) {

            }

        }
        editPassword.addTextChangedListener(watcher)

    }
}