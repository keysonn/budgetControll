package com.example.budgetcontroll

import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import com.example.budgetcontroll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigatorView.selectedItemId = R.id.linkToMain
        binding.bottomNavigatorView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.linkToMain -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                R.id.linkToHistory -> {
                    val intent = Intent(this, History::class.java)
                    startActivity(intent)
                }

                R.id.linkToReport -> {
                    val intent = Intent(this, Report::class.java)
                    startActivity(intent)
                }
            }
            true
        }
    }
}