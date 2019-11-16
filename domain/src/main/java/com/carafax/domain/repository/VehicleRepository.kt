package com.carafax.domain.repository

import com.carafax.domain.Vehicle
import rx.Observable

/**
 * Facilitates the requesting of data from the data layer by use of Rx Observables
 */
interface VehicleRepository {
    //gets Vehicle list data
    fun getVehicles() : Observable<List<Vehicle>>
}