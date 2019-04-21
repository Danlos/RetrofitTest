package com.danlos.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.danlos.test.model.User
import com.danlos.test.webapi.MyEndpoinInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


class MainActivity : AppCompatActivity() {

    val BASE_URL = "https://my.api.mockaroo.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

        var apiService = retrofit.create(MyEndpoinInterface::class.java)
        var key = "14c1ce50"
        var call = apiService.getUsers(key)
        var disposable = call.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse, this::handleError)

    }

    fun handleResponse(users: List<User>){
        Log.d("DNLS" , users.toString())
    }

    fun handleError(e: Throwable){
        e.printStackTrace()
    }
}
