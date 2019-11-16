package com.carafax.data.repository

import com.carafax.data.entity.VehicleEntityMapper
import com.carafax.data.net.RestApi
import com.carafax.domain.Vehicle
import com.carafax.domain.repository.VehicleRepository
import rx.Observable
import javax.inject.Inject

/**
 * implements the user Repository from domain layer to get the required data from api
 */
class VehicleDataRepository @Inject constructor(val restApi: RestApi, val vehicleEntityMapper: VehicleEntityMapper) : VehicleRepository{

    override fun getVehicles(): Observable<List<Vehicle>> {
       return restApi.carEntityData().map { results -> vehicleEntityMapper.transform(results) }  //can cache data if necessary before returning
    }

}