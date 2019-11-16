package com.carafax

import android.app.Application
import com.carafax.dependencies.components.ApplicationComponent
import com.carafax.dependencies.components.DaggerApplicationComponent
import com.carafax.dependencies.modules.ApplicationModule

class CARFAXApplication : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }
    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    private fun initializeInjector() {

        applicationComponent =  DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }


}