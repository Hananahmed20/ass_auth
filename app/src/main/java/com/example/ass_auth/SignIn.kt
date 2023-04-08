package com.example.ass_auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignIn : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        // val currentUser = auth.currentUser
        auth = Firebase.auth
        var edt_email = findViewById<EditText>(R.id.edt_email)
        var edt_password = findViewById<EditText>(R.id.edt_password)
        var btn_singin = findViewById<Button>(R.id.btn_singin)
        var btn_log_out = findViewById<Button>(R.id.btn_log_out)

        var email = edt_email.text
        var password = edt_password.text

        btn_singin.setOnClickListener {
            singin(email.toString(), password.toString())
        }
        btn_log_out.setOnClickListener {
            var i = Intent(this, SingUpActivity::class.java)
            startActivity(i)
        }
    }

    fun updateUI() {
        var i = Intent(this, details::class.java)
        startActivity(i)
    }
    fun singin(email:String,password:String){
        auth.signInWithEmailAndPassword(email.toString(), password.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("Hanan", "signInWithEmail:success")
                    updateUI()
                } else {
                    Log.w("Hanan", "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}