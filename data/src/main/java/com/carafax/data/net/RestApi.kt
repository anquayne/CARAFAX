package com.carafax.data.net

import com.carafax.data.entity.VehicleEntity
import rx.Observable

/**
 * Allows subscription to specific observables which retrieves data from api service and updates subscriber once data is retrieved
 */
interface RestApi{

    fun carEntityData() : Observable<VehicleEntity>
}