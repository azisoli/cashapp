package com.example.cashappproject.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Stock(
    @Json(name = "ticker")
    val ticker: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "currency")
    val currency: String,
    @Json(name = "current_price_cents")
    val current_price_cents: Int,
    @Json(name = "quantity")
    val quantity: Int?,
    @Json(name = "current_price_timestamp")
    val current_price_timestamp: Int
) : Parcelable
