package com.example.budgetcontroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.budgetcontroll.databinding.ActivityChangeBinding

class ChangeActivity : AppCompatActivity() {

    lateinit var binding: ActivityChangeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)

        binding = ActivityChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linkToMain2: Button = findViewById(R.id.linkToMain2)
        linkToMain2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        initButton()
    }
    private fun initButton() = with(binding) {
        toDoChange.setOnClickListener{
            val change = ChangesHistory(from.text.toString(), where.text.toString(), howMany.text.toString())
            val editIntent = Intent().apply {
                putExtra("change", change)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}