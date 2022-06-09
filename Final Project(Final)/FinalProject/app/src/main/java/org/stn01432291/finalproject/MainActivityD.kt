package org.stn01432291.finalproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.NonNull
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.regex.Pattern

class MainActivityD : AppCompatActivity() {

    lateinit var preferences: SharedPreferences

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

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val currentEmail= preferences.getString("EMAIL", "")



        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.info -> {
                    val intent = Intent(this, Info::class.java)
                    startActivity(intent)
                }
                R.id.view -> {
                    val intent = Intent(this, AppHistory::class.java)
                    startActivity(intent)
                }
                R.id.cancel -> {
                    val intent = Intent(this, CancelAppointment::class.java)
                    startActivity(intent)
                }
                R.id.shedule -> {
                    //Do Nothing This is the current Activity
                }
                R.id.LogOut -> {
                    val intent = Intent(this, LogIn::class.java)
                    startActivity(intent)
                }
            }
        }


        //Creates an appointment by adding the users info to the data base.
        btnSchedule.setOnClickListener {

            val dbHandler = MyDBOpenHelper(this, null)

            if (TextUtils.isEmpty((editName.getText().toString()))) {
                Toast.makeText(this, "Name Cannot Be Empty", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty((editPhone.getText().toString()))) {
                Toast.makeText(this, "Phone Number Cannot Be Empty", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty((editDesc.getText().toString()))) {
                Toast.makeText(this, "Appointment Description Cannot Be Empty", Toast.LENGTH_SHORT)
                    .show()
            } else if (TextUtils.isEmpty((editDate.getText().toString()))) {
                Toast.makeText(this, "Appointment Date Cannot Be Empty", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty((editTime.getText().toString()))) {
                Toast.makeText(this, "Appointment Time Cannot Be Empty", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty((editAddress.getText().toString()))) {
                Toast.makeText(this, "Address Cannot Be Empty", Toast.LENGTH_SHORT).show()
            } else {
                dbHandler.addName(
                    editName.text.toString(),
                    editPhone.text.toString(),
                    editDate.text.toString(),
                    editTime.text.toString(),
                    editAddress.text.toString(),
                    editDesc.text.toString(),
                    currentEmail.toString()
                )
                Toast.makeText(
                    this,
                    "Thanks " + editName.text.toString() + " We will get back to you as soon as possible ",
                    Toast.LENGTH_SHORT
                ).show()
            }

            editName.setText("")
            editPhone.setText("")
            editDesc.setText("")
            editDate.setText("")
            editAddress.setText("")
            editTime.setText("")
        }

    }
}



