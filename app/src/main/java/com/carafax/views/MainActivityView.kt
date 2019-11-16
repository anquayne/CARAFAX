package com.carafax.views

import com.carafax.models.VehicleListModel

interface MainActivityView{
    val getCurrentSDKVersion: Int

    fun renderVehicleList(vehicleList : ArrayList<VehicleListModel>)
    fun showMessage(message : String)
    fun isPermissionGranted(s: String): Boolean
    fun requestPermission()
    fun callDealer(dealerNumber: String)
}