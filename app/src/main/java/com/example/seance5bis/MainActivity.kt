package com.example.seance5bis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {

    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tab_layout)

        tabLayout.addOnTabSelectedListener(this)

        displayFirstFragment()

    }

    private fun displayFirstFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, FirstTabFragment.newInstance())
            .commit()
    }

    private fun displaySecondFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, SecondTabFragment.newInstance())
            .commit()
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        Log.i("Tab", "onTabSelected")
        tab?.let {
            when (it.position) {
                0 -> displayFirstFragment()
                1 -> displaySecondFragment()
            }
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        Log.i("Tab", "onTabUnselected")
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        Log.i("Tab", "onTabReselected")
    }
}