package com.example.dependencyinjectionroomdb.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjectionroomdb.Utils.DataState
import com.example.dependencyinjectionroomdb.models.ProductList
import com.example.dependencyinjectionroomdb.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductViewmodel
@Inject constructor(private val repository: ProductRepository): ViewModel() {
    private val _getProductListResponse: MutableLiveData<DataState<Response<List<ProductList>>>> = MutableLiveData()
    val getProductListResponse: LiveData<DataState<Response<List<ProductList>>>> get() = _getProductListResponse

    fun getProductList(
    ) = viewModelScope.launch {
        _getProductListResponse.value = DataState.Loading
        _getProductListResponse.value = repository.getProducts()
    }
}