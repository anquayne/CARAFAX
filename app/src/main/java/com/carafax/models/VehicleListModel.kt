package com.carafax.models

import java.io.Serializable

/**
 * data Class to model specific data for rendering
 */
data class VehicleListModel(val vehicleId : String) : Serializable {
    var vehicleName : String? = null
    var vehiclePhotoUrl : String? = null
    var vehiclePrice : Double? =null
    var vehicleLocation : String? = null
    var vehicleMileage : String? = null
    var vehicleCarDealerNumber : String? = null
}