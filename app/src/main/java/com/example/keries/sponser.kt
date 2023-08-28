package com.example.keries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query


class sponser : Fragment() {


    private lateinit var sponsorRecyclerView: RecyclerView
    private lateinit var sponseradapter: SponsorAdapter
    private val db = FirebaseFirestore.getInstance()
    private  var SponserList : MutableList<sponserDataClass> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sponser, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sponsorRecyclerView = view.findViewById(R.id.sponserRecylerView)
        sponseradapter = SponsorAdapter(SponserList)
        sponsorRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        sponsorRecyclerView.adapter = sponseradapter
        fetchFirestoreData()


    }

    private fun fetchFirestoreData() {
        val db = FirebaseFirestore.getInstance()
        db.collection("sponsors")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val name = document.getString("name") ?: ""
                    val url = document.getString("url") ?: ""
                    val desgination = document.getString("title")?:""
                    val item = sponserDataClass(name,desgination,url)
                    SponserList.add(item)
                }
                sponseradapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireContext(),"Something went wrong",Toast.LENGTH_SHORT).show()

            }
    }


}