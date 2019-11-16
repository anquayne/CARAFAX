package com.carafax.data.entity

import android.util.Log
import com.carafax.domain.Vehicle
import javax.inject.Inject

class VehicleEntityMapper @Inject constructor() {

    fun transform(vehicleEntity: VehicleEntity): List<Vehicle> {

        val vehicles: ArrayList<Vehicle> = ArrayList()

        for (listing in vehicleEntity.listings) {

            val vehicle = Vehicle(listing.id)
            vehicle.vehiclePhotoLink = listing.images?.firstPhoto?.large
            vehicle.vehicleCallDealerNumber = listing.dealer?.phone
            vehicles.add(vehicle)
        }

        return vehicles
    }

}