package com.android.liciousdemo.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.liciousdemo.data.HomeRepository
import com.android.liciousdemo.model.Filter
import com.android.liciousdemo.model.Product
import com.android.liciousdemo.model.ViewType
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(val homeRepository: HomeRepository) : ViewModel() {

    val products = mutableListOf<ViewType<Product>>()
    val result = MutableLiveData<List<ViewType<Product>>>()
    val filters = MutableLiveData<List<Filter>>()

    init {
        viewModelScope.launch {
            val response = homeRepository.getProducts()
            products.clear()
            products.addAll(response.products)
            result.postValue(response.products)
            filters.postValue(response.filters)
        }
    }

    fun filterExpressDeliverProducts(filter: String) {
        when (filter) {
            "all" -> {
                result.postValue(products)
            }
            "express" -> {
                val filterList = products?.filter {
                    val data = it.data

                    data.productMercahntdising.deliveryType.equals(filter, true)
                }
                result.postValue(filterList)
            }
        }

    }
}