package com.organization.frb.interfaces

import com.organization.frb.entities.Category
import com.organization.frb.entities.Meal
import com.organization.frb.entities.MealResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface to get services from API
 *
 * Services contains category, filter and lookup
 */

interface GetDataService {
    @GET("categories.php")
    fun getCategoryList(): Call<Category>

    @GET("filter.php")
    fun getMealList(@Query("c") category: String): Call<Meal>

    @GET("lookup.php")
    fun getSpecificItem(@Query("i") id: String): Call<MealResponse>


}