package com.example.cashappproject.network

import com.example.cashappproject.model.ResponseStock
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiServices {

    @GET("cash-stocks-api/portfolio.json")
    suspend fun getStockDeals(
    ): Response<ResponseStock>

    @GET("cash-stocks-api/portfolio_malformed.json")
    suspend fun getMalformed(
    ): Response<ResponseStock>

    @GET("cash-stocks-api/portfolio_empty.json")
    suspend fun getEmpty(
    ): Response<ResponseStock>


}