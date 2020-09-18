package com.shidqi.githubprofiles.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.shidqi.githubprofiles.R
import com.shidqi.githubprofiles.database.ItemDatabase
import com.shidqi.githubprofiles.repository.ProfileRepository
import com.shidqi.githubprofiles.repository.SearchRepository
import com.shidqi.githubprofiles.ui.viewmodel.ItemViewModel
import com.shidqi.githubprofiles.ui.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_search_user.*

class SearchActivity : AppCompatActivity() {

    lateinit var viewModel1: ItemViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
//        setSupportActionBar(findViewById(R.id.profile_toolbar))
//        bottomNavigationView.setupWithNavController(profileNavHostFragment.findNavController())

        val navController = findNavController(R.id.profileNavHostFragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        main_toolbar?.setupWithNavController(navController, appBarConfiguration)



        val itemRepository = SearchRepository(ItemDatabase(this))
        val viewModelProviderFactory1 = ItemViewModelProviderFactory(itemRepository)
        viewModel1 =
            ViewModelProvider(this, viewModelProviderFactory1).get(ItemViewModel::class.java)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miSettings -> Toast.makeText(this, "you clicked Setting", Toast.LENGTH_SHORT)
                .show()
            R.id.miAbout -> Toast.makeText(this, "you clicked About", Toast.LENGTH_SHORT).show()
        }
        return true
    }


}