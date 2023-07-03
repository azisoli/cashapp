package com.example.cashappproject.network

import com.example.cashappproject.model.ResponseStock
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val service: ApiServices)
{
    suspend fun fetchStockDeals(
    ): Response<ResponseStock> {
        val response = service.getStockDeals()
        return if (response.isSuccessful) {
            Response.success(response.body())
        } else {
            Response.error(response.code(), response.errorBody())
        }
    }

    suspend fun fetchMalformed(
    ): Response<ResponseStock> {
        val response = service.getMalformed()
        return if (response.isSuccessful) {
            Response.success(response.body())
        } else {
            Response.error(response.code(), response.errorBody())
        }
    }
    suspend fun fetchEmpty(
    ): Response<ResponseStock> {
        val response = service.getEmpty()
        return if (response.isSuccessful) {
            Response.success(response.body())
        } else {
            Response.error(response.code(), response.errorBody())
        }
    }
}