package com.hamdy.gadsleaderboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamdy.gadsleaderboard.ui.leadership.LeadershipActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val intent=Intent(this, LeadershipActivity::class.java)
        val t: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(1000)
                    startActivity(intent)
                    finish()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        t.start()
    }
}