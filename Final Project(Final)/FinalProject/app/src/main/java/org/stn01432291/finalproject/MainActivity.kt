package org.stn01432291.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSchedule = findViewById<Button>(R.id.btnSch)
        val editName = findViewById<EditText>(R.id.editName)
        val editPhone = findViewById<EditText>(R.id.editPhoneNumber)
        val editDesc = findViewById<EditText>(R.id.editDesc)
        val editDate = findViewById<EditText>(R.id.editDate)
        val editTime = findViewById<EditText>(R.id.editTime)
        val editAddress = findViewById<EditText>(R.id.editAddress)
        val backBtn = findViewById<Button>(R.id.btnBack)

        //Creates an appointment by adding the users info to the data base.
        btnSchedule.setOnClickListener {

            val dbHandler = MyDBOpenHelper(this, null)

            if(TextUtils.isEmpty((editName.getText().toString()))){
                Toast.makeText(this, "Name Cannot Be Empty", Toast.LENGTH_SHORT).show()
            }else if(TextUtils.isEmpty((editPhone.getText().toString()))) {
                Toast.makeText(this, "Phone Number Cannot Be Empty", Toast.LENGTH_SHORT).show()
            }else if(TextUtils.isEmpty((editDesc.getText().toString()))){
                Toast.makeText(this, "Appointment Description Cannot Be Empty", Toast.LENGTH_SHORT).show()
            }else if(TextUtils.isEmpty((editDate.getText().toString()))){
                Toast.makeText(this, "Appointment Date Cannot Be Empty", Toast.LENGTH_SHORT).show()
            }else if(TextUtils.isEmpty((editTime.getText().toString()))){
                Toast.makeText(this, "Appointment Time Cannot Be Empty", Toast.LENGTH_SHORT).show()
            }else {
                dbHandler.addName(
                    editName.text.toString(),
                    editPhone.text.toString(),
                    editDate.text.toString(),
                    editTime.text.toString(),
                    editAddress.text.toString(),
                    editDesc.text.toString(),
                    editDesc.text.toString()
                )
                Toast.makeText(this, editTime.text.toString(), Toast.LENGTH_SHORT).show()
                //Toast.makeText(this, "Thanks "+ editName.text.toString() + " We will get back to you as soon as possible ", Toast.LENGTH_SHORT).show()
            }

            editName.setText("")
            editPhone.setText("")
            editDesc.setText("")
            editDate.setText("")
            editTime.setText("")
        }

        backBtn.setOnClickListener(){
            val menu = Intent(this, MainMenu::class.java)
            startActivity(menu)
        }


    }



}