package com.example.kotlintodopractice.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kotlintodopractice.R
import com.google.firebase.auth.FirebaseAuth


class SplashFragment : Fragment() {


    private lateinit var mAuth: FirebaseAuth
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)

        Handler(Looper.getMainLooper()).postDelayed({
            if (mAuth.currentUser != null) {
                // Usuario logueado -> ir a Home
                navController.navigate(R.id.action_splashFragment_to_homeFragment)
            } else {
                // Usuario NO logueado -> ir a Login
                navController.navigate(R.id.action_splashFragment_to_signInFragment)
            }
        }, 2000)
    }

    private fun init(view: View) {
        mAuth = FirebaseAuth.getInstance()
        navController = Navigation.findNavController(view)
    }
}