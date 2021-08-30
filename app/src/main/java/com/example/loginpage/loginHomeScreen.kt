package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.homescreen_layout.*

class loginHomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homescreen_layout)
        var b:Bundle? = intent.extras
        var WelcomeName = "Welcome " + b?.getString("name")
        welcome_name.setText(WelcomeName)
        signout_button.setOnClickListener(){
            Toast.makeText(this,"Sign Out Successfully",Toast.LENGTH_SHORT).show()
            val i=Intent(this,MainActivity::class.java)
            startActivity(i);
            }
        addcontact_button.setOnClickListener(){
            val i1=Intent(this,addContact::class.java)
            startActivity(i1);
        }
        displaycontacts_button.setOnClickListener(){
            val i2 = Intent(this,DisplayContacts::class.java)
            startActivity(i2);
        }
        deletecontact_button.setOnClickListener() {
            val i3=Intent(this,DeleteContact::class.java)
            startActivity(i3)
        }
    }
}