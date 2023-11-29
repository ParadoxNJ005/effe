package com.example.keries.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.keries.R
import com.google.firebase.firestore.FirebaseFirestore

class splashscreen : AppCompatActivity() {
    private val SPLASH_DELAY = 2000L // 2 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        // Initialize Firebase
        val firestore = FirebaseFirestore.getInstance()

        // Using a Handler to delay the transition to the main activity
        Handler().postDelayed({
            firestore.collection("Effe_Date")
                .get()
                .addOnSuccessListener { documents ->
                    if (!documents.isEmpty) {
                        val fetchedData = documents.documents[0].data // Modify this as per your data structure
                        val mainIntent = Intent(this, BaseHome::class.java)
                        startActivity(mainIntent)
                        finish()
                    } else {

                    }
                }
                .addOnFailureListener { exception ->

                }
        }, SPLASH_DELAY)
    }
}
