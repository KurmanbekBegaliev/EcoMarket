package com.example.ecomarket.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ecomarket.R
import com.example.ecomarket.databinding.ActivityMainBinding
import com.example.ecomarket.tools.viewVisibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val navHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHost.navController

        setSupportActionBar(binding.mainToolbar)
        setupBar()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) findNavController(R.id.nav_host_fragment).navigateUp()
        return true
    }

    private fun setupBar() {
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainFragment,
                R.id.infoFragment,
                R.id.basketFragment,
                R.id.storyFragment,
            )
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
//            supportActionBar?.title = when (destination.id) {
//                R.id.mainFragment -> "Эко маркет"
//                R.id.infoFragment -> "Инфо"
//                R.id.productsFragment -> "Продукты"
//                R.id.storyFragment -> "История"
//                R.id.basketFragment -> "Корзина"
////                R.id.mainFragment -> ""
//                else -> "no title"
//            }
            if (destination.id == R.id.infoFragment) {
                supportActionBar?.hide()
            } else if (destination.id == R.id.productsFragment) {
                binding.navView.viewVisibility(false)
                supportActionBar?.setHomeButtonEnabled(true)
            } else {
                supportActionBar?.show()
                binding.navView.viewVisibility(true)
            }
        }


        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

    }
}