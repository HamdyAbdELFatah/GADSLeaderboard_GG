package com.hamdy.gadsleaderboard.network
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstanceSubmission {

    companion object {
        private val retrofit by lazy {
            val client = OkHttpClient
                .Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val mApi: ApiClients by lazy { retrofit.create(ApiClients::class.java) }

    }
}
