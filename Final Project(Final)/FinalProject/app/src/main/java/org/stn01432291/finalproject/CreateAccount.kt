package org.stn01432291.finalproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CreateAccount : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        var btnBack = findViewById<Button>(R.id.btnBackCreateAccount)
        var btnCreate = findViewById<Button>(R.id.btnCreateAccount)


        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        btnBack.setOnClickListener(){
            val login = Intent(this, LogIn::class.java)
            startActivity(login)
        }

        btnCreate.setOnClickListener(){
            var inputError = false;
            var errorMsg = ""
            var editEmailCreateAccount = findViewById<EditText>(R.id.editEmailSignUP)
            var editPassSignUP = findViewById<EditText>(R.id.editPassSignUp)
            var editCardNum = findViewById<EditText>(R.id.editCardNum)
            var editCardCvv = findViewById<EditText>(R.id.editCardCvv)
            var editCardExDate = findViewById<EditText>(R.id.editCardEXDate)

            //Empty Validation
            if(TextUtils.isEmpty((editEmailCreateAccount.getText().toString()))){
                inputError = true;
                errorMsg = "Email Cannot Be Empty"
            }
            else if(TextUtils.isEmpty((editPassSignUP.getText().toString()))) {
               inputError = true
                errorMsg = "Password Cannot Be Empty"
            }
            else if(TextUtils.isEmpty((editCardNum.getText().toString()))){
                inputError = true
                errorMsg = "Card Number Cannot Be Empty"
            }
            else if(TextUtils.isEmpty((editCardCvv.getText().toString()))){
                inputError = true
                errorMsg = "Card Cvv Cannot Be Empty"
            }
            else if(TextUtils.isEmpty((editCardExDate.getText().toString()))){
                inputError = true
                errorMsg = "Card Expiry Date Cannot Be Empty"
            }

            if(!android.util.Patterns.EMAIL_ADDRESS.matcher(editEmailCreateAccount.getText().toString()).matches()){
                inputError = true
                errorMsg = "Wrong Format For Email"
            }


            if(inputError == true){
                Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("EMAIL", editEmailCreateAccount.text.toString())
            editor.putString("PASS", editPassSignUP.text.toString())
            editor.putString("CARDNUM", editCardNum.text.toString())
            editor.putString("CARDCVV", editCardCvv.text.toString())
            editor.putString("CARDDATE", editCardExDate.text.toString())
            editor.apply()


            Toast.makeText(this, "Account Successfully Created", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LogIn::class.java)
            val email = editEmailCreateAccount.text.toString()
            val pass = editPassSignUP.text.toString()
            intent.putExtra("EMAIL", email)
            intent.putExtra("PASS", pass)
            startActivity(intent)
            finish()
        }


    }

}