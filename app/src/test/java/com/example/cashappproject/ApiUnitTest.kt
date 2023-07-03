package com.example.cashappproject
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class ApiUnitTest {
    @Test
    fun testApi() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://storage.googleapis.com/cash-homework/cash-stocks-api/portfolio.json")
            .build()

        val response = client.newCall(request).execute()

        assertNotNull(response)
        assertEquals(200, response.code)

        val responseBody = response.body?.string()
        assertNotNull(responseBody)


    }
}
