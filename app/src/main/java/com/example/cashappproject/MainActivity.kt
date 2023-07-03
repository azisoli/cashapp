package com.example.cashappproject


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cashappproject.databinding.ActivityMainBinding
import com.example.cashappproject.network.Status
import com.example.cashappproject.viewModel.StockViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: StockViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.err.visibility = View.GONE
        binding.rec.visibility = View.VISIBLE
        binding.button.setOnClickListener { viewModel.fetchStocks() }
        binding.loadError.setOnClickListener { viewModel.fetchMalformed() }
        binding.loadEmpty.setOnClickListener { viewModel.fetchEmpty() }

        viewModel.stocks.observe(this) {
            if (it.size > 0) {
                val adapter = StockAdapter(it)
                val recyclerView: RecyclerView = findViewById(R.id.rec)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this)
                binding.rec.visibility = View.VISIBLE
                binding.err.visibility = View.GONE
            } else {
                binding.err.text = "no result to show!"
                binding.err.visibility = View.VISIBLE
                binding.rec.visibility = View.GONE
            }
        }

        viewModel.updateUI.observe(this) {
            if (it.status == Status.ERROR) {
                binding.err.text = "oops ! something went wrong : " + it.message
                binding.err.visibility = View.VISIBLE
                binding.rec.visibility = View.GONE
            }
        }
    }


}