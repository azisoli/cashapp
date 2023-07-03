package com.example.cashappproject.viewModel


import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cashappproject.model.Stock
import com.example.cashappproject.network.NetworkHelper
import com.example.cashappproject.network.Repository
import com.example.cashappproject.network.Resource
import com.example.cashappproject.network.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class StockViewModel @Inject constructor(
    private val repository: Repository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private var _stocks: MutableLiveData<List<Stock>> = MutableLiveData()
    val stocks: LiveData<List<Stock>>
        get() = _stocks
    private var _updateUI: MutableLiveData<Resource<String>> = MutableLiveData()
    val updateUI: LiveData<Resource<String>>
        get() = _updateUI

    fun fetchStocks() {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                try {
                    repository.fetchStockDeals().let { stocks ->
                        if (stocks.isSuccessful) {
                            stocks.body()?.stocks?.let { it ->
                                if (it.size > 0) {
                                    _stocks.postValue(it)
                                }else{
                                    _updateUI.value = Resource(Status.ERROR, null, "no result to show!")
                                }
                            }
                        } else {
                            _updateUI.value = Resource(Status.ERROR, null, stocks.message())
                        }

                    }
                } catch (ex: Exception) {
                    _updateUI.value = Resource(Status.ERROR, null, ex.message)
                }
            } else {
                _updateUI.value = Resource(Status.ERROR, null, "no internet connection")
            }

        }
    }

    fun fetchMalformed() {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                try {
                    repository.fetchMalformed().let { stocks ->
                        if (stocks.isSuccessful) {
                            stocks.body()?.stocks?.let { it ->
                                if (it.size > 0) {
                                    _stocks.postValue(it)
                                }else{
                                    _updateUI.value = Resource(Status.ERROR, null, "no result to show!")
                                }
                            }
                        } else {
                            _updateUI.value = Resource(Status.ERROR, null, stocks.message())
                        }

                    }
                } catch (ex: Exception) {
                    _updateUI.value = Resource(Status.ERROR, null, ex.message)
                }
            } else {
                _updateUI.value = Resource(Status.ERROR, null, "no internet connection")
            }

        }
    }

    fun fetchEmpty() {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                try {
                    repository.fetchEmpty().let { stocks ->
                        if (stocks.isSuccessful) {
                            stocks.body()?.stocks?.let { it ->
                                if (it.size > 0) {
                                    _stocks.postValue(it)
                                }else{
                                    _updateUI.value = Resource(Status.ERROR, null, "no result to show!")
                                }
                            }
                        } else {
                            _updateUI.value = Resource(Status.ERROR, null, stocks.message())
                        }

                    }
                } catch (ex: Exception) {
                    _updateUI.value = Resource(Status.ERROR, null, ex.message)
                }
            } else {
                _updateUI.value = Resource(Status.ERROR, null, "no internet connection")
            }

        }
    }
}