package ccom.organization.frb.retofitclient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Create an client to store the Base URL from the website
 * Get network calls from application
 * Convert java to JSON format using Gson
 */

class RetrofitClientInstance {
    companion object{
        val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
        private var retrofit: Retrofit? = null
        val retrofitInstance: Retrofit?
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit
            }
    }

}