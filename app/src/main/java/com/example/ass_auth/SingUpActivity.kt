package com.example.ass_auth

import android.annotation.SuppressLint
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

class SingUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){
            updateUI()
        }

    }
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

         var  btn_login = findViewById<Button>(R.id.btn_login)
         var edt_email = findViewById<EditText>(R.id.edt_email)
        var edt_password = findViewById<EditText>(R.id.edt_password)
        var btn_singup = findViewById<Button>(R.id.btn_singup)

         auth = Firebase.auth
        var email = edt_email.text
        var password = edt_password.text

        btn_singup.setOnClickListener {
            Log.e("Hanan", email.toString())
            Log.e("Hanan", password.toString())
            createNewAccount(email.toString(), password.toString())
        }
            btn_login.setOnClickListener{
                var i = Intent(this, SignIn::class.java)
                startActivity(i)
            }

     }
    fun updateUI() {
        var i = Intent(this, SignIn::class.java)
        startActivity(i)
    }
    private fun createNewAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("Hanan", "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI()
                } else {
                    Log.w("Hanan", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }


    }


}