package com.carafax.dependencies.modules

import com.carafax.domain.executor.PostExecutionThread
import com.carafax.domain.executor.ThreadExecutor
import com.carafax.domain.interactor.GetVehicleListData
import com.carafax.domain.interactor.UseCase
import com.carafax.domain.repository.VehicleRepository
import com.carafax.dependencies.components.UserScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class VehicleModule{

    @Provides
    @UserScope
    @Named(GetVehicleListData.NAME)
    internal fun provideVehicleDataUseCase(vehicleRepository: VehicleRepository, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread): UseCase {
        return GetVehicleListData(threadExecutor,postExecutionThread,vehicleRepository)
    }
}