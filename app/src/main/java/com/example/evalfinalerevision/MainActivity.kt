package com.example.evalfinalerevision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.evalfinalerevision.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        val bottomNavigationView = binding.bottomNavigationView
        val navControler = findNavController(R.id.navHostFragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navControler)
        NavigationUI.setupActionBarWithNavController(this, navControler)


    }
}