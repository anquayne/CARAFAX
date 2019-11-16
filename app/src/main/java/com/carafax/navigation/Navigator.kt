package com.carafax.navigation

import android.content.Context
import com.carafax.models.VehicleListModel
import com.carafax.views.activity.VehicleDetailsActivity
import javax.inject.Inject

/**
 * class used to navigate between all the activities within the application
 */
class Navigator @Inject constructor(){

    fun navigateToVehicleDetailsActivity(context : Context, vehicleListModel: VehicleListModel ){
        val intentToLaunch = VehicleDetailsActivity.getCallingIntent(context)
        intentToLaunch.putExtra("vehicleModel",vehicleListModel)
        context.startActivity(intentToLaunch)
    }
}