package com.carafax.presenters

import com.carafax.models.VehicleListModel
import com.carafax.views.VehicleDetailsView

class VehicleDetailsPresenter {

    var view : VehicleDetailsView? = null
    private var dealerNumber : String? = null

    fun initialise(vehicleDetails : VehicleListModel){
        view?.renderVehicleDetails(vehicleDetails)
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