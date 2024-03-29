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
            vehicleModel.vehicleLocation = data.vehicleLocation
            vehicleModel.vehicleName = data.vehicleYear.toString()+" "+data.vehicleMake+" "+data.vehicleModel +" "+ data.vehicleTrim
            vehicleModel.vehiclePrice = data.vehiclePrice
            vehicleModel.vehicleMileage = data.vehicleMileage.toString() + "k mi"
            vehicleModel.vehicleExteriorColor = data.vehicleExteriorColor
            vehicleModel.vehicleInteriorColor = data.vehicleInteriorColor
            vehicleModel.vehicleBodyStyle = data.vehicleBodyStyle
            vehicleModel.vehicleDriveType = data.vehicleDriveType
            vehicleModel.vehicleTransmission = data.vehicleTransmission
            vehicleModel.vehicleEngine = data.vehicleEngine
            vehicleModel.vehicleFuel = data.vehicleFuel
            vehicleModelList.add(vehicleModel)
        }
        return vehicleModelList
    }
}