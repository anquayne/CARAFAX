package com.carafax.presenters

import android.os.Build
import com.carafax.data.exception.NetworkConnectionException
import com.carafax.domain.Vehicle
import com.carafax.domain.interactor.GetVehicleListData
import com.carafax.domain.interactor.UseCase
import com.carafax.models.mappers.VehicleListModelMapper
import com.carafax.views.MainActivityView
import rx.Subscriber
import javax.inject.Inject
import javax.inject.Named

/**
 * Presenter to manage all main activity logics and get data to update main activity view
 */
class MainActivityPresenter @Inject constructor(@Named(GetVehicleListData.NAME) val vehicleUseCase: UseCase, val vehicleListModelMapper : VehicleListModelMapper){

    var view : MainActivityView? = null
    var dealerNumber : String? = null

    /**
     * Method to get things started in the presenter
     */
    fun initialise(){
        //load user data
        loadVehicleData()
    }



    /**
     * Method to load vehicle data via UseCase from domain layer
     */
    private fun loadVehicleData(){

        vehicleUseCase.execute(object: Subscriber<Any>() {
            override fun onCompleted() {

            }

            override fun onError(e: Throwable?) {
                if(e is NetworkConnectionException){
                    view?.showMessage("No Internet")
                }

                e?.printStackTrace()
            }

            override fun onNext(t: Any?) {

                @Suppress("UNCHECKED_CAST")
                view?.renderVehicleList(vehicleListModelMapper.transform(t as List<Vehicle>)) // update view with results from api
            }
        })
    }

    fun callVehicleDealer(dealerNumber: String) {
        this.dealerNumber = dealerNumber
        if (view?.getCurrentSDKVersion!! >= 23 && !view?.isPermissionGranted("android.permission.CALL_PHONE")!!) {
            view?.requestPermission()
        } else {
            view?.callDealer(dealerNumber)
        }
    }

    fun requestPermissionResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == 30) {
            if (view?.isPermissionGranted("android.permission.CALL_PHONE")!!) {
                dealerNumber?.let { view?.callDealer(it) }
            } else {
                view?.showMessage("Cannot Initiate call without your permission")
            }
        }
    }

}