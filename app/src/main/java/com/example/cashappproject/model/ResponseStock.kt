package com.example.cashappproject.model

import android.os.Parcelable

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ResponseStock(
    @Json(name = "stocks")
    val stocks: List<Stock>? = null
) : Parcelable
