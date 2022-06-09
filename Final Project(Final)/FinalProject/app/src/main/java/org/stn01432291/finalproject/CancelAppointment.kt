package org.stn01432291.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.Exception

class CancelAppointment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancel_appointment)

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
                    //Do Nothing This is the current Activity
                }
                R.id.shedule -> {
                    //Do Nothing This is the current Activity
                    val intent = Intent(this, MainActivityD::class.java)
                    startActivity(intent)
                }
                R.id.LogOut -> {
                    val intent = Intent(this, LogIn::class.java)
                    startActivity(intent)
                }
            }
        }


    }

    fun cancelApp(view: android.view.View) {
        var editCancelPhone = findViewById<EditText>(R.id.editCancelPhone)
        try {

            val dbHandler = MyDBOpenHelper(this, null)

            dbHandler.delete(editCancelPhone.text.toString())

            Toast.makeText(this, "Appointment Deleted", Toast.LENGTH_SHORT).show()

        }catch (E: Exception){
            Toast.makeText(this, "Error Appointment Was Not Deleted", Toast.LENGTH_SHORT).show()
        }
    }
}