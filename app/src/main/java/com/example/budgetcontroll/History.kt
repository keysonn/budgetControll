package com.example.budgetcontroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgetcontroll.databinding.ActivityHistoryBinding

class History : AppCompatActivity() {

    lateinit var binding: ActivityHistoryBinding
    private val adapter = ChangesAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null

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
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK) {
                adapter.addChange(it.data?.getSerializableExtra("change") as ChangesHistory)
            }
        }
    }

    private fun init() {
        binding.apply{
            rcView.layoutManager =GridLayoutManager(this@History, 3)
            rcView.adapter = adapter
            bAdd.setOnClickListener{
                editLauncher?.launch(Intent(this@History, ChangeActivity::class.java))
            }
        }
    }
}