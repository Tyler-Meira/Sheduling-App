package org.stn01432291.finalproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.w3c.dom.Text
import java.lang.Exception

class AppHistory : AppCompatActivity() {
    lateinit var preferences: SharedPreferences

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_history)

            var appHistory = findViewById<TextView>(R.id.viewOutput)
            appHistory.setText(" ")

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
                    //Do Nothing
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

        try {
            val dbHandler = MyDBOpenHelper(this, null)

            val cursor = dbHandler.getAllName(currentEmail.toString())

            cursor!!.moveToFirst()

            appHistory.append(
                (cursor.getString(
                    cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME1)
                ))
            )
            appHistory.append("\n")

            appHistory.append(
                (cursor.getString(
                    cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME2)
                ))
            )
            appHistory.append("\n")

            appHistory.append(
                (cursor.getString(
                    cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME3)
                ))
            )
            appHistory.append("\n")

            appHistory.append(
                (cursor.getString(
                    cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME4)
                ))
            )
            appHistory.append("\n")

            appHistory.append(
                (cursor.getString(
                    cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME5)
                ))
            )
            appHistory.append("\n")

            appHistory.append(
                (cursor.getString(
                    cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME6)
                ))
            )
            appHistory.append("\n\n")

            while (cursor.moveToNext()) {

                appHistory.append(
                    (cursor.getString(
                        cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME1)
                    ))
                )
                appHistory.append("\n")

                appHistory.append(
                    (cursor.getString(
                        cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME2)
                    ))
                )
                appHistory.append("\n")

                appHistory.append(
                    (cursor.getString(
                        cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME3)
                    ))
                )
                appHistory.append("\n")

                appHistory.append(
                    (cursor.getString(
                        cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME4)
                    ))
                )
                appHistory.append("\n")

                appHistory.append(
                    (cursor.getString(
                        cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME5)
                    ))
                )
                appHistory.append("\n")

                appHistory.append(
                    (cursor.getString(
                        cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME6)
                    ))
                )
                appHistory.append("\n\n")
            }
                cursor.close()
                Toast.makeText(this, "Showing Data", Toast.LENGTH_SHORT).show()
        }catch (E: Exception){
            Toast.makeText(this, "Error No Data Found", Toast.LENGTH_SHORT).show()
        }





    }
}