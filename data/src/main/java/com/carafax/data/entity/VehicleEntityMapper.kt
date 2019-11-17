package com.carafax.data.entity

import com.carafax.domain.Vehicle
import javax.inject.Inject

class VehicleEntityMapper @Inject constructor() {

    fun transform(vehicleEntity: VehicleEntity): List<Vehicle> {

        val vehicles: ArrayList<Vehicle> = ArrayList()

        for (listing in vehicleEntity.listings) {

            val vehicle = Vehicle(listing.id)
            vehicle.vehiclePhotoLink = listing.images?.firstPhoto?.large
            vehicle.vehicleInteriorColor = listing.interiorColor
            vehicle.vehicleLocation = listing.dealer?.address
            vehicle.vehicleMake = listing.make
            vehicle.vehicleModel = listing.model
            vehicle.vehiclePrice = listing.listPrice
            vehicle.vehicleTrim = listing.trim
            vehicle.vehicleYear = listing.year
            vehicle.vehicleMileage = listing.mileage
            vehicle.vehicleCallDealerNumber = listing.dealer?.phone
            vehicle.vehicleExteriorColor = listing.exteriorColor
            vehicle.vehicleBodyStyle = listing.bodytype
            vehicle.vehicleDriveType = listing.drivetype
            vehicle.vehicleTransmission = listing.transmission
            vehicle.vehicleEngine = listing.engine
            vehicle.vehicleFuel = listing.fuel
            vehicles.add(vehicle)
        }

        return vehicles
    }

}