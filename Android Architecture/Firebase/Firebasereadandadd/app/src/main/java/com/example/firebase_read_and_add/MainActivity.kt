package com.example.firebase_read_and_add

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        if(mAuth.currentUser!=null){
            Toast.makeText(this, "You already in", Toast.LENGTH_SHORT).show()
        }

        check_btn.setOnClickListener {
            val email = inputUsername.text.toString()
            val password = inputPassword.text.toString()
            if (validate(email, password)) {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful) {
                        Toast.makeText(this,"Login succesfull", Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(this,"You must have entered the wrong email or password", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this,"Please enter email and password", Toast.LENGTH_SHORT).show()
            }

        }

        changeActivity_btn.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun validate(email: String, password: String) =
        email.isNotEmpty() && password.isNotEmpty()
}