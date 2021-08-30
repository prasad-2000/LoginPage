package com.example.loginpage
import android.database.SQLException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.register_layout.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a=DBHelper(this)
        var b=a.readableDatabase

        login_button.setOnClickListener() {
            var args=listOf<String>(user_name.text.toString(),user_password.text.toString()).toTypedArray()
            var rs=b.rawQuery("SELECT * FROM ADMIN WHERE UNAME=? and PASS=?",args)
            var loginname = user_name.text.toString()
            var loginpassword = user_password.text.toString()
            if (loginname.isEmpty()) {
                user_name.error = "User Name Needed"
                return@setOnClickListener
            } else if (loginpassword.isEmpty()) {
                user_password.error = "User Password Needed"
                return@setOnClickListener
            }
            if(rs.moveToNext()){
                val i = Intent(this, loginHomeScreen::class.java)
                var nameIndex= rs.getColumnIndex("NAME")
                var loginName=rs.getString(nameIndex)
                i.putExtra("name",loginName)
                Toast.makeText(this,"Login Successfully !",Toast.LENGTH_SHORT).show()
                startActivity(i);
            }else{
                Toast.makeText(this,"Invalid Credentials !",Toast.LENGTH_SHORT).show()
            }

        }

        register_button.setOnClickListener(){
            val i =Intent(this,RegisterActivity::class.java)
            startActivity(i);
        }
    }
}