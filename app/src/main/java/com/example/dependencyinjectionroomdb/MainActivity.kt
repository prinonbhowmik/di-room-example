package com.example.dependencyinjectionroomdb

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencyinjectionroomdb.Utils.DataState
import com.example.dependencyinjectionroomdb.adapter.ProductAdapter
import com.example.dependencyinjectionroomdb.databinding.ActivityMainBinding
import com.example.dependencyinjectionroomdb.viewmodels.ProductViewmodel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel :ProductViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ProductViewmodel::class.java]
        viewModel.getProductList()
        viewModel.getProductListResponse.observe(this, Observer {
            when(it){

                is DataState.Error -> {}
                DataState.Loading -> {}
                is DataState.Success -> {
                    val body = it.value.body()
                    binding.recyclerView.layoutManager = LinearLayoutManager(this)
                    binding.recyclerView.adapter = body?.let { it1 -> ProductAdapter(it1) }
                }
            }
        })

    }
}