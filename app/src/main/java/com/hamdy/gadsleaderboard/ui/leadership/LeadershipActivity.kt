package com.hamdy.gadsleaderboard.ui.leadership

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hamdy.gadsleaderboard.R
import com.hamdy.gadsleaderboard.ui.submit.SubmitActivity
import kotlinx.android.synthetic.main.activity_leadership.*

class LeadershipActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leadership)
        initViewPager2WithFragments()
        submitButton.setOnClickListener {
            startActivity(Intent(this@LeadershipActivity,SubmitActivity::class.java))
        }
    }

    private fun initViewPager2WithFragments() {
        val viewPager2: ViewPager2 = findViewById(R.id.ViewPager)
        val adapter = LeadershipViewPager(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        val names:Array<String> = arrayOf("Learning Leaders", "Skill IQ Leaders")
        TabLayoutMediator(tabLayout, viewPager2){ tab, position ->
            tab.text = names[position]
        }.attach()

    }
}