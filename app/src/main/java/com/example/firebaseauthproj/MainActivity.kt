package com.example.firebaseauthproj

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var loginBtn : Button

    lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.edEmail)
        password = findViewById(R.id.edPassword)
        loginBtn = findViewById(R.id.button)

        auth = FirebaseAuth.getInstance()


        loginBtn.setOnClickListener {
            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnSuccessListener {
                    Toast.makeText(this@MainActivity, "User Successfully Login", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this@MainActivity, "User Failed ${it.message}", Toast.LENGTH_LONG).show()
                }
        }


    }
}