package com.example.budgetcontroll

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgetcontroll.databinding.ActivityHistoryBinding
import com.example.budgetcontroll.databinding.ActivityMainBinding

class History : AppCompatActivity() {

    lateinit var binding: ActivityHistoryBinding
    private val adapter = ChangesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigatorView.selectedItemId = R.id.linkToHistory
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
        init()
    }

    private fun init() {
        binding.apply{
            rcView.layoutManager = LinearLayoutManager(this@History)
            rcView.adapter = adapter
        }
    }
}