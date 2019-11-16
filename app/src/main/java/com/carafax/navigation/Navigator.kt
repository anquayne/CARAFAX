package com.carafax.navigation

import android.content.Context
import com.carafax.models.VehicleListModel
import javax.inject.Inject

/**
 * class used to navigate between all the activities within the application
 */
class Navigator @Inject constructor(){

    fun navigateToMapActivity(context : Context, user1 : VehicleListModel, user2 : VehicleListModel){
//        val intentToLaunch = MapsActivity.getCallingIntent(context)
//        intentToLaunch.putExtra("user1",user1)
//        intentToLaunch.putExtra("user2",user2)
//        context.startActivity(intentToLaunch)
    }
}