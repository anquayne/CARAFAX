package com.carafax.dependencies.modules

import android.app.Application
import android.content.Context
import com.carafax.UIThread
import com.carafax.data.cache.FileManager
import com.carafax.data.cache.VehicleCache
import com.carafax.data.cache.VehicleCacheImpl
import com.carafax.data.executor.JobExecutor
import com.carafax.data.net.RestApi
import com.carafax.data.net.RestApiImpl
import com.carafax.data.repository.VehicleDataRepository
import com.carafax.domain.executor.PostExecutionThread
import com.carafax.domain.executor.ThreadExecutor
import com.carafax.domain.repository.VehicleRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application){

    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context {
        return this.application
    }

    @Provides
    @Singleton
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    internal fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @Singleton
    internal fun provideRestApiImpl(restApiImpl: RestApiImpl): RestApi {
        return restApiImpl
    }

    @Provides
    @Singleton
    internal fun provideUserRepository(carDataRepository: VehicleDataRepository): VehicleRepository {
        return carDataRepository
    }

    @Provides
    @Singleton
    internal fun providesVehicleCache(vehicleCahce: VehicleCacheImpl): VehicleCache {
        return vehicleCahce
    }

    @Provides
    @Singleton
    internal fun providesFileManager(): FileManager {
        return FileManager(application)
    }


}