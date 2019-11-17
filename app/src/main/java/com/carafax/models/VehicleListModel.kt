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
    var vehicleExteriorColor : String? = null
    var vehicleInteriorColor : String? = null
    var vehicleDriveType : String? = null
    var vehicleTransmission : String? = null
    var vehicleEngine : String? = null
    var vehicleFuel : String? = null
    var vehicleBodyStyle: String? = null
    var vehicleCarDealerNumber : String? = null
}