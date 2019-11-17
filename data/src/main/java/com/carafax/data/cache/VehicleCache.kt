package com.carafax.data.cache

import com.carafax.data.entity.VehicleEntity
import rx.Observable

interface VehicleCache{

    fun get() : Observable<VehicleEntity>
    fun isCached(cacheId : String) : Boolean
    fun put(vehicleEntity: VehicleEntity)
}