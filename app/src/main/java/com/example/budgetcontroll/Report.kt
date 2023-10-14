package com.example.budgetcontroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.budgetcontroll.databinding.ActivityHistoryBinding
import com.example.budgetcontroll.databinding.ActivityReportBinding

class Report : AppCompatActivity() {

    lateinit var binding: ActivityReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigatorView.selectedItemId = R.id.linkToReport
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