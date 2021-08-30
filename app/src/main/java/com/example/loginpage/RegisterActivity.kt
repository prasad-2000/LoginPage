package com.example.loginpage
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.register_layout.*
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_layout)
        var helper=DBHelper(this)
        var dbTable=helper.readableDatabase
        registerbutton2.setOnClickListener(){
            val username= register_userName.text.toString()
            val name=register_name.text.toString()
            val regpas=register_password.text.toString()
            val regpas2=register_password2.text.toString()
            if(username.isNotEmpty()&&name.isNotEmpty()&&regpas.isNotEmpty()&&(regpas2==regpas)){
                var cv=ContentValues()
                cv.put("NAME",name)
                cv.put("UNAME",username)
                cv.put("PASS",regpas)
                dbTable.insert("ADMIN",null,cv)
                Toast.makeText(this,"Registered Successfully", Toast.LENGTH_SHORT).show()
                val i= Intent(this,MainActivity::class.java)
                startActivity(i)
            }else{
                Toast.makeText(this,"Enter Details Carefully",Toast.LENGTH_SHORT).show()
            }

        }
    }
}