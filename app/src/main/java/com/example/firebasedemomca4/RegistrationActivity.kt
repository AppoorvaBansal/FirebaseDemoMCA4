package com.example.firebasedemomca4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        auth = FirebaseAuth.getInstance()

        btnforloginpage.setOnClickListener {

            var intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }


        btnlogin.setOnClickListener {

            var email:String=edemail.text.toString()
            var pass=edpass.text.toString()
            var confirmpass=edconfpass.text.toString()

           if(check(email)) {
           }
            else if(check(pass)) {
           }
            else if(check(confirmpass)){}

            else if(pass!=confirmpass) {
               Toast.makeText(this, "PASS DOSENT MATCH", Toast.LENGTH_LONG).show()
           }

            else {
                    // eneter the data into database

               auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {

                   if(it.isSuccessful)
                   Toast.makeText(this,"REGISTRATION SUCCESSFULL",Toast.LENGTH_LONG).show()
                   else
                       Toast.makeText(this,it.exception?.localizedMessage,Toast.LENGTH_LONG).show()
               }
           }



        }
    }


    fun check(str:String):Boolean
    {
        if(str=="")
        {
            Toast.makeText(this,"FEILD IS EMPTY",Toast.LENGTH_LONG).show()
            return true
        }
        else
            return false

    }
}
