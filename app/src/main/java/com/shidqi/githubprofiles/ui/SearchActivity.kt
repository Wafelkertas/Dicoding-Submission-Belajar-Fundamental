package com.shidqi.githubprofiles.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.shidqi.githubprofiles.R
import com.shidqi.githubprofiles.database.ItemDatabase
import com.shidqi.githubprofiles.repository.ProfileRepository
import com.shidqi.githubprofiles.repository.SearchRepository
import com.shidqi.githubprofiles.ui.viewmodel.ItemViewModel
import com.shidqi.githubprofiles.ui.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    lateinit var viewModel1: ItemViewModel
    lateinit var viewModel2: ProfileViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
//        setSupportActionBar(findViewById(R.id.toolbar))
        bottomNavigationView.setupWithNavController(profileNavHostFragment.findNavController())

        val itemRepository = SearchRepository(ItemDatabase(this))
        val viewModelProviderFactory1 = ItemViewModelProviderFactory(itemRepository)
        viewModel1 = ViewModelProvider(this, viewModelProviderFactory1).get(ItemViewModel::class.java)

        val profileRepository = ProfileRepository(ItemDatabase(this))
        val viewModelProviderFactory2 = ProfileViewModelProviderFactory(profileRepository)
        viewModel2 = ViewModelProvider(this, viewModelProviderFactory2).get(ProfileViewModel::class.java)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miSettings -> Toast.makeText(this, "you clicked Setting", Toast.LENGTH_SHORT).show()
            R.id.miAbout -> Toast.makeText(this, "you clicked About", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}