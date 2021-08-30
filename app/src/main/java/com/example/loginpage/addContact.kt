package com.example.loginpage

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.addcontact_layout.*

class addContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addcontact_layout)
        var helper=DBHelper(this)
        var dbTable=helper.readableDatabase
        submit_buttton.setOnClickListener() {
            var contactname = addname.text.toString()
            var contactemail = addemail.text.toString()
            var contactphno = addphno.text.toString()
            if (contactname.isEmpty()) {
                Toast.makeText(applicationContext, "Enter Your Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (contactemail.isEmpty()) {
                Toast.makeText(applicationContext, "Enter Your Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (contactphno.isEmpty()) {
                Toast.makeText(applicationContext, "Enter Your Ph.No", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else {
                var cv = ContentValues()
                cv.put("CNAME", contactname)
                cv.put("EMAIL", contactemail)
                cv.put("PHNO", contactphno)
                dbTable.insert("ADDCONTACT", null, cv)
                Toast.makeText(this, "Submitted Successfully", Toast.LENGTH_SHORT).show()
                val i = Intent(this, loginHomeScreen::class.java)
                startActivity(i)
            }
        }

    }
}