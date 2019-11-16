package com.carafax.data.net

import com.carafax.data.entity.VehicleEntity
import retrofit2.Call
import retrofit2.http.GET

/**
 * Retrofit Interface wrapper for Api
 * This interface provides all the api request for the Application
 * And handles the payload with specific entity type
 */
interface ApiService{

    @get : GET("assignment.json")
    val users: Call<VehicleEntity>
}