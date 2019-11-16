package com.carafax.views

import com.carafax.models.VehicleListModel

interface VehicleDetailsView{
    val getCurrentSDKVersion: Int
    fun renderVehicleDetails(vehicleListModel: VehicleListModel)
    fun showMessage(message : String)
    fun isPermissionGranted(s: String): Boolean
    fun requestPermission()
    fun callDealer(dealerNumber: String)
}
