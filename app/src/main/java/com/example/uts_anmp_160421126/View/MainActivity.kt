package com.example.uts_anmp_160421126.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.uts_anmp_160421126.R
import com.example.uts_anmp_160421126.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = (supportFragmentManager.findFragmentById(R.id.FragmentHost)as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this,navController,binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.botNav, navController)
        binding.botNav.setupWithNavController(navController)

        navController = (supportFragmentManager.findFragmentById(R.id.FragmentHost) as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this,navController)
    }
}