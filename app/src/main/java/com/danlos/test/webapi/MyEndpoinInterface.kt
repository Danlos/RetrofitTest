package com.danlos.test.webapi

import com.danlos.test.model.User
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyEndpoinInterface {
    @GET("users.json")
    fun getUsers(@Query("key") key: String): Observable<List<User>>
}