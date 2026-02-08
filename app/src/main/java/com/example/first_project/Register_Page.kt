package com.example.first_project

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Register_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn_back: ImageView = findViewById(R.id.btn_back)
        btn_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
        val txt_From_Register_To_Login: TextView = findViewById(R.id.txt_From_Register_To_Login)
        txt_From_Register_To_Login.setOnClickListener {
            val Login = Intent(this, Login_Page::class.java)
            startActivity(Login)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        val inputuser: EditText = findViewById(R.id.et_R_1)
        val btnRegister: Button = findViewById(R.id.btn_R_1)

        btnRegister.setOnClickListener {
            val text = inputuser.text.toString()


            val nickname = Intent(this, After_Register::class.java)
            nickname.putExtra("text_name", text)
            startActivity(nickname)
        }

        val editPassword: EditText = findViewById(R.id.et_R_3)
        val editConPass: EditText = findViewById(R.id.et_R_4)
        val btnLogin: Button = findViewById(R.id.btn_R_1)

        btnLogin.isEnabled = false
        btnLogin.alpha = 0.5f // efek tombol nonaktif

        val watcher = object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val password = editPassword.text.toString().trim()
                val confPass = editConPass.text.toString().trim()



                if (password.isEmpty()) {
                    editPassword.error = "Password tidak boleh kosong"
                } else {
                    editPassword.error = null
                }

                val isFilled = password.isNotEmpty() && confPass.isNotEmpty()
                btnLogin.isEnabled = isFilled
                btnLogin.alpha = if (isFilled) 1f else 0.5f


            }

            override fun afterTextChanged(s: Editable?) {}

        }



        editPassword.addTextChangedListener(watcher)
        editConPass.addTextChangedListener(watcher)
    }
}
