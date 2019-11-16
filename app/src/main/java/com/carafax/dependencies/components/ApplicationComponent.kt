package com.carafax.dependencies.components

import android.content.Context
import com.carafax.domain.executor.PostExecutionThread
import com.carafax.domain.executor.ThreadExecutor
import com.carafax.domain.repository.VehicleRepository
import com.carafax.dependencies.modules.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent{

    //Exposed to sub-graphs.
    fun context(): Context

    fun threadExecutor(): ThreadExecutor
    fun postExecutionThread(): PostExecutionThread
    fun userRepository(): VehicleRepository
}