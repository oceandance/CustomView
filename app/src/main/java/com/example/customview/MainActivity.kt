package com.example.customview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.customview.customview.sky.SkyActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showSkyBtn = findViewById<Button>(R.id.show_sky_btn)
        showSkyBtn.setOnClickListener {
            val intent = Intent(this, SkyActivity::class.java)
            startActivity(intent)
        }
    }
}