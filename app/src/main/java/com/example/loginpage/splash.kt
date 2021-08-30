package com.example.loginpage
import android.content.Intent
import android.graphics.Color.alpha
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.splash.*

class splash:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        home_image.alpha =0f
        home_image.animate().setDuration(2000).alpha(1f).withEndAction{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}