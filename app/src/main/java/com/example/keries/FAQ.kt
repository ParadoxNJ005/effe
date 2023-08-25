//package com.example.keries
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import android.view.animation.Animation
//import android.view.animation.TranslateAnimation
//
//class FAQ : Fragment() {
//
//    private var b1 = false
//    private var b2 = false
//    private var b3 = false
//    private var b4 = false
//    private var b5 = false
//    private var b6 = false
//
//
//
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_f_a_q2, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val d1= view.findViewById<ImageView>(R.id.d1)
//        val d2= view.findViewById<ImageView>(R.id.d2)
//        val d3= view.findViewById<ImageView>(R.id.d3)
//        val d4= view.findViewById<ImageView>(R.id.d4)
//        val d5= view.findViewById<ImageView>(R.id.d5)
//        val d6= view.findViewById<ImageView>(R.id.d6)
//        val a1 = view.findViewById<TextView>(R.id.a1)
//        val a2 = view.findViewById<TextView>(R.id.a2)
//        val a3 = view.findViewById<TextView>(R.id.a3)
//        val a4 = view.findViewById<TextView>(R.id.a4)
//        val a5 = view.findViewById<TextView>(R.id.a5)
//        val a6 = view.findViewById<TextView>(R.id.a6)
//
//
//
//
//
//        d1.setOnClickListener {
//            downFunction(a1,d1,b1)
//        }
//        d2.setOnClickListener {
//            downFunction(a2,d2,b2)
//        }
//        d3.setOnClickListener {
//            downFunction(a3,d3,b3)
//        }
//        d4.setOnClickListener {
//            downFunction(a4,d4,b4)
//        }
//        d5.setOnClickListener {
//            downFunction(a5,d5,b5)
//        }
//        d6.setOnClickListener {
//            downFunction(a6,d6,b6)
//        }
//
//    }
//    private fun downFunction(a: TextView,d:ImageView,b:Boolean){
//
//        if (b) {
//            a.visibility = View.GONE
//            d.animate().rotation(0F)
//            b = false
//        } else {
//            a.visibility = View.VISIBLE
//            d.animate().rotation(180F)
//            b = true
//        }
//    }
//
//
//
//}

package com.example.keries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.view.animation.Animation
import android.view.animation.TranslateAnimation

class FAQ : Fragment() {

    private val buttonStates = mutableMapOf<ImageView, Boolean>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f_a_q2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val d1 = view.findViewById<ImageView>(R.id.d1)
        val d2 = view.findViewById<ImageView>(R.id.d2)
        val d3 = view.findViewById<ImageView>(R.id.d3)
        val d4 = view.findViewById<ImageView>(R.id.d4)
        val d5 = view.findViewById<ImageView>(R.id.d5)
        val d6 = view.findViewById<ImageView>(R.id.d6)
        val a1 = view.findViewById<TextView>(R.id.a1)
        val a2 = view.findViewById<TextView>(R.id.a2)
        val a3 = view.findViewById<TextView>(R.id.a3)
        val a4 = view.findViewById<TextView>(R.id.a4)
        val a5 = view.findViewById<TextView>(R.id.a5)
        val a6 = view.findViewById<TextView>(R.id.a6)


        val retw = view.findViewById<ImageView>(R.id.boso)

        retw.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        // Initialize button states
        buttonStates[d1] = false
        buttonStates[d2] = false
        buttonStates[d3] = false
        buttonStates[d4] = false
        buttonStates[d5] = false
        buttonStates[d6] = false

        d1.setOnClickListener {
            downFunction(a1, d1)
        }
        d2.setOnClickListener {
            downFunction(a2, d2)
        }
        d3.setOnClickListener {
            downFunction(a3, d3)
        }
        d4.setOnClickListener {
            downFunction(a4, d4)
        }
        d5.setOnClickListener {
            downFunction(a5, d5)
        }
        d6.setOnClickListener {
            downFunction(a6, d6)
        }
    }

    private fun downFunction(a: TextView, d: ImageView) {
        val currentState = buttonStates[d] ?: false

        if (currentState) {
            a.visibility = View.GONE
            d.animate().rotation(0F)
        } else {
            a.visibility = View.VISIBLE
            d.animate().rotation(180F)
        }

        // Update the state in the map
        buttonStates[d] = !currentState
    }
}
