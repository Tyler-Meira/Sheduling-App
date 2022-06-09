package org.stn01432291.finalproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class Info : AppCompatActivity() {

    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val back = findViewById<Button>(R.id.btnBackInfo)



        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.info -> {
                    //Do Nothing This is the current Activity
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
}