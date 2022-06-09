package org.stn01432291.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val btnMakeAPP = findViewById<Button>(R.id.btnMakeAPP)
        val btnView = findViewById<Button>(R.id.btnViewApps)
        val btnInfo = findViewById<Button>(R.id.btnInfo)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val btnCancel = findViewById<Button>(R.id.btnCancel)


        btnMakeAPP.setOnClickListener(){
            val makeAPP = Intent(this, MainActivityD::class.java)
            startActivity(makeAPP)
        }

        btnLogout.setOnClickListener(){
            val login = Intent(this, LogIn::class.java)
            startActivity(login)
        }

        btnView.setOnClickListener(){
            val view = Intent(this, AppHistory::class.java)
            startActivity(view)
        }

        btnInfo.setOnClickListener(){
            val view = Intent(this, Info::class.java)
            startActivity(view)
        }

        btnCancel.setOnClickListener(){
            val cancel = Intent(this, CancelAppointment::class.java)
            startActivity(cancel)
        }

    }

}