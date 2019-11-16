package com.carafax.data.net

import android.content.Context
import android.net.ConnectivityManager
import com.carafax.data.entity.VehicleEntity
import com.carafax.data.exception.NetworkConnectionException
import rx.Observable
import rx.Subscriber
import java.lang.Exception
import javax.inject.Inject

/**
 * Class to implement Observables that retrieves thr data from api service and return results to subscribers
 */
class RestApiImpl @Inject constructor(val context: Context, private val apiConnection : ApiConnection) : RestApi{

    override fun carEntityData(): Observable<VehicleEntity> {
       return Observable.create {subscriber -> if(isNetworkConnected()) getUsers(subscriber) else subscriber.onError(NetworkConnectionException())}
    }

    //method to do the api call and return results via subscriber
    private fun getUsers(subscriber: Subscriber<in VehicleEntity>){
        val response = apiConnection.retrofit().users.execute()
        if (response.isSuccessful) subscriber.onNext(response.body())
        else subscriber.onError( Exception(response.errorBody().toString()))
    }

    //method to check if there is internet
    private fun isNetworkConnected() : Boolean{


        val connectivityManager = this.context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }
}