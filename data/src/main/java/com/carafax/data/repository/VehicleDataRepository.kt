package com.carafax.data.repository

import com.carafax.data.cache.VehicleCache
import com.carafax.data.cache.VehicleCacheImpl
import com.carafax.data.entity.VehicleEntityMapper
import com.carafax.data.net.RestApi
import com.carafax.domain.Vehicle
import com.carafax.domain.repository.VehicleRepository
import rx.Observable
import javax.inject.Inject

/**
 * implements the user Repository from domain layer to get the required data from api
 */
class VehicleDataRepository @Inject constructor(private val restApi: RestApi, private val vehicleEntityMapper: VehicleEntityMapper, private val vehicleCache: VehicleCache) : VehicleRepository{

    override fun getVehicles(): Observable<List<Vehicle>> {
       if(vehicleCache.isCached("vehicle")){
           return restApi.carEntityData().publish { api -> Observable.merge(api,vehicleCache.get().takeUntil(api)) } //use cache data util api data is retrieved
               .onErrorResumeNext(vehicleCache.get()) // if there is an error more likely from api don't instantly kill try to  get cache data only
               .doOnNext{data -> vehicleCache.put(data)}.map { results -> vehicleEntityMapper.transform(results) }
       }
       return restApi.carEntityData().doOnNext{data -> vehicleCache.put(data)}.map { results -> vehicleEntityMapper.transform(results) }
    }

}