package com.carafax.models.mappers

import android.util.Log
import com.carafax.domain.Vehicle
import com.carafax.models.VehicleListModel
import javax.inject.Inject

class VehicleListModelMapper @Inject constructor(){

    fun transform(vehicle : List<Vehicle>) : ArrayList<VehicleListModel>{
        val vehicleModelList = ArrayList<VehicleListModel>()
        for (data in vehicle){

            val vehicleModel = VehicleListModel(data.vehicleId)
            vehicleModel.vehiclePhotoUrl = data.vehiclePhotoLink
            vehicleModel.vehicleCarDealerNumber = data.vehicleCallDealerNumber

            vehicleModelList.add(vehicleModel)
        }
        return vehicleModelList
    }
}