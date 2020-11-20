package com.shidqi.githubprofiles.ui

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.shidqi.githubprofiles.R
import com.shidqi.githubprofiles.database.ItemDatabase
import com.shidqi.githubprofiles.repository.ProfileRepository
import com.shidqi.githubprofiles.repository.SearchRepository
import com.shidqi.githubprofiles.ui.viewmodel.ItemViewModel
import com.shidqi.githubprofiles.ui.viewmodel.ProfileViewModel
import com.shidqi.githubprofiles.ui.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_search_user.*

class SearchActivity : AppCompatActivity() {



    lateinit var itemViewModel: ItemViewModel
    lateinit var profileViewModel: ProfileViewModel
    lateinit var userViewModel: UserViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        bottomNavigation.setupWithNavController(profileNavHostFragment.findNavController())




        val profileRepository = ProfileRepository(ItemDatabase(this))
        val profileViewModelProviderFactory = ProfileViewModelProviderFactory(profileRepository)
        profileViewModel =
            ViewModelProvider(this, profileViewModelProviderFactory).get(ProfileViewModel::class.java)

        val userViewModelProviderFactory = UserViewModelProviderFactory(profileRepository)
        userViewModel =
            ViewModelProvider(this, userViewModelProviderFactory).get(UserViewModel::class.java)

        val itemRepository = SearchRepository()
        val itemViewModelProviderFactory = ItemViewModelProviderFactory(itemRepository)
        itemViewModel =
            ViewModelProvider(this, itemViewModelProviderFactory).get(ItemViewModel::class.java)






    }




}