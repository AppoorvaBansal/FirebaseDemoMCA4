package com.example.firebasedemomca4.FirebaseStorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.firebasedemomca4.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.activity_user_profile_registration.*

class UserProfileRegistrationActivity : AppCompatActivity() {

    val db = Firebase.firestore
  var user : HashMap<String,String>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile_registration)
        user=HashMap<String,String>()





        btnuserreg.setOnClickListener {
//Log.d("Response","Id: "+id + user!!.get("Id"))

            var id:String=edid.text.toString()
            user!!.put("Id",id)
            user!!.put("Name",edname.text.toString())
            user!!.put("Course",edcourse.text.toString())
            user!!.put("Email","xyz@gmail.com")
            user!!.put("Phone",edphone.text.toString())
            user!!.put("State",edstate.text.toString())
            Toast.makeText(this,id + edid.text.toString(),Toast.LENGTH_LONG).show()

            Toast.makeText(this,"id: "+user!!.get("Id"),Toast.LENGTH_LONG).show()
            Toast.makeText(this,"email: "+user!!.get("Email"),Toast.LENGTH_LONG).show()

            db.collection("User").add(user!!)
                .addOnSuccessListener {
                response->
                Toast.makeText(this,"Successfull",Toast.LENGTH_LONG).show()
            }
                .addOnFailureListener({
                    e->
                    Toast.makeText(this,"ERROR   "+ e.localizedMessage,Toast.LENGTH_LONG).show()

                })

            val ur=db.collection("User")

            ur.document("user1").set(user!!)

            }

        btnRead.setOnClickListener {

            val docRef = db.collection("User").document("user1")
            docRef.get()
                .addOnSuccessListener { document ->
                    if (document != null) {
                        Log.d("Response", "DocumentSnapshot data: ${document.data}")
                    } else {
                        Log.d("Response", "No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d("Response", "get failed with ", exception)
                }

            db.collection("User")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d("Response", "${document.id} => ${document.data}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("Response", "Error getting documents.", exception)
                }


        }
        }

    }

