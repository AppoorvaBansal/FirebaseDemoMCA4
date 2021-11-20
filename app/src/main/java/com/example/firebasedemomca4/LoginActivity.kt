package com.example.firebasedemomca4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        btnuserreg.setOnClickListener {
            auth.signInWithEmailAndPassword(edemail.text.toString(),edphone.text.toString()).addOnCompleteListener {

                if(it.isSuccessful)
                {
                    var intent= Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                else
                    Toast.makeText(this,it.exception?.localizedMessage, Toast.LENGTH_LONG).show()

            }
        }
    }
}
