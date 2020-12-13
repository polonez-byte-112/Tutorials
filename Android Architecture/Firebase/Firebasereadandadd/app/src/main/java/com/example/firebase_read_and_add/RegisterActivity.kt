package com.example.firebase_read_and_add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference
        register_btn.setOnClickListener {
            val email = registerEmail.text.toString()
            val name = registerName.text.toString()
            val age = registerAge.text.toString()
            val password = registerPassword.text.toString()
            val hobby = registerHobby.text.toString()

            if(validate(email,name,age, password,hobby)){

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) {
                    if(it.isSuccessful){
                        // to key to jest unikalne id uzytkownika
                        writeNewUser(database.push().key.toString(),email,name,age,password,hobby)
                        Toast.makeText(this,"Register succesfull", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"Register fail", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this,"Please fill all columns", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun validate(email: String, name: String,age:String, password: String, hobby:String) =
        email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty() && hobby.isNotEmpty() && age.isNotEmpty()


    private fun writeNewUser(userId : String, email: String, name: String,age:String, password: String, hobby:String) {
        val user = User(age,email,hobby, name, password,)
        database.child("users").child(userId).setValue(user)
    }
}