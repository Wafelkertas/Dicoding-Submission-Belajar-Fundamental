package com.shidqi.githubprofiles.ui.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shidqi.githubprofiles.R
import com.shidqi.githubprofiles.utils.ALARM_ID_REPEATING
import com.shidqi.githubprofiles.utils.AlarmHelper
import com.shidqi.githubprofiles.utils.PREFERENCES_REMINDER_STATE
import com.shidqi.githubprofiles.utils.PREFERENCES_NAME
import kotlinx.android.synthetic.main.fragment_setting.*
import java.util.*

class SettingsFragment : Fragment(R.layout.fragment_setting) {


    private lateinit var sharedPreferences: SharedPreferences


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setting_btn_back.setOnClickListener {
            findNavController().navigateUp()
        }

        change_language.setOnClickListener {
            startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
        }


        sharedPreferences =
            activity?.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)!!


        daily_reminder.apply {
            isChecked = sharedPreferences.getBoolean(PREFERENCES_REMINDER_STATE, false)

            setOnCheckedChangeListener { _, isChecked ->
                setReminder(isChecked)
            }


        }


    }

    private fun setReminder(reminder: Boolean) {
        sharedPreferences.edit().apply {
            this?.putBoolean(PREFERENCES_REMINDER_STATE, reminder)
        }.apply()

        context?.let {
            if (reminder) {
                AlarmHelper.createAlarm(
                    it,
                    getString(R.string.app_name),
                    getString(R.string.daily_reminder),
                    ALARM_ID_REPEATING,
                    Calendar.getInstance().apply {
                        set(Calendar.HOUR_OF_DAY, 9)
                        set(Calendar.MINUTE, 0)
                        set(Calendar.SECOND, 0)
                    }
                )
            } else {
                AlarmHelper.cancelAlarm(it, ALARM_ID_REPEATING)
            }
        }
    }


}