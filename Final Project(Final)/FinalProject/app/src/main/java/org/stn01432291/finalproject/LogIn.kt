package org.stn01432291.finalproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LogIn : AppCompatActivity() {

    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        var editEmail = findViewById<EditText>(R.id.editEmail)
        var editPass = findViewById<EditText>(R.id.editPass)
        var btnSign = findViewById<Button>(R.id.btnSignUp)
        var btnLogIn = findViewById<Button>(R.id.btnLogin)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val email= preferences.getString("EMAIL", "")
        val pass= preferences.getString("PASS", "")
        editEmail.setText(email)

        btnLogIn.setOnClickListener(){
            if(editPass.text.toString() == pass && email == editEmail.text.toString()){
                val intent = Intent(this, MainActivityD::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Incorrect Password Or Email, Try Again", Toast.LENGTH_SHORT).show()
            }
        }

        btnSign.setOnClickListener(){
            val createAccount = Intent(this, CreateAccount::class.java)
            startActivity(createAccount)
        }


    }
}