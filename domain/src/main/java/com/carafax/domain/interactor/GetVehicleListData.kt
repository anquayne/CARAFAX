package com.carafax.domain.interactor

import com.carafax.domain.executor.PostExecutionThread
import com.carafax.domain.executor.ThreadExecutor
import com.carafax.domain.repository.VehicleRepository
import rx.Observable

/**
 * Gets the car data from the data layer to be displayed by presentation layer
 * This use case requires the VehicleRepository
 */
class GetVehicleListData(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread, private val vehicleRepository: VehicleRepository) :
    UseCase(threadExecutor, postExecutionThread) {
    companion object{
        const val NAME : String = "GetVehicleListData"
    }
    override fun buildUseCaseObservable(): Observable<*> {
        return vehicleRepository.getVehicles()
    }
}