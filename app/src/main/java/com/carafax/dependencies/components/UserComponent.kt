package com.carafax.dependencies.components

import com.carafax.dependencies.modules.VehicleModule
import com.carafax.views.activity.MainActivity
import dagger.Component

@UserScope
@Component(dependencies = [ApplicationComponent::class], modules = [VehicleModule::class])
interface UserComponent{
    fun inject(mainActivity: MainActivity)
}
