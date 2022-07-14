package com.example.walkthroughscreen.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.walkthroughscreen.R
import com.example.walkthroughscreen.adapter.ViewPagerAdapter
import com.example.walkthroughscreen.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewPager()
        initEvents()

    }

    private fun initViewPager() {
        binding.viewPager.adapter = ViewPagerAdapter(this, this)
        TabLayoutMediator(binding.pageIndicator, binding.viewPager) {_, _ -> }.attach()
        binding.viewPager.offscreenPageLimit = 1
    }

    private fun initEvents() {
        start()
    }

    private fun start() {
        binding.btnCreateAccount.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}