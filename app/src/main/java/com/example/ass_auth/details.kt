package com.example.ass_auth

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class details : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        auth = Firebase.auth
        val user = Firebase.auth.currentUser

        var edt_email = findViewById<TextView>(R.id.txt_show_email)
        var edt_password = findViewById<TextView>(R.id.txt_id_user)
        var btn_logout = findViewById<Button>(R.id.btn_logout)

        edt_email.text = user!!.email
        edt_password.text = user.uid

        btn_logout.setOnClickListener {
            Firebase.auth.signOut()
            var i = Intent(this, SignIn::class.java)
            startActivity(i)
        }

    }
}