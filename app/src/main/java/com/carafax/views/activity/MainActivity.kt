package com.carafax.views.activity

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.android.material.snackbar.Snackbar
import com.carafax.CARFAXApplication
import com.carafax.dependencies.components.DaggerUserComponent
import com.carafax.views.adapters.VehicleAdapter

import com.carafax.dependencies.components.UserComponent
import com.carafax.dependencies.modules.VehicleModule
import com.carafax.models.VehicleListModel
import com.carafax.presenters.MainActivityPresenter
import com.carafax.views.MainActivityView
import javax.inject.Inject
import android.net.Uri
import android.os.Build
import androidx.core.content.PermissionChecker
import com.carafax.R


class MainActivity : BaseActivity() , MainActivityView {

    @BindView(R.id.user_recycler_view)
    lateinit var userRecyclerView : RecyclerView

    @BindView(R.id.coordinator_layout)
    lateinit var coordinatorLayout : CoordinatorLayout

    private var vehicleAdapter : VehicleAdapter? = null
    private var userComponent : UserComponent? = null

    private var users : ArrayList<VehicleListModel> = ArrayList()


    @Inject
    lateinit var presenter : MainActivityPresenter

    companion object {
        /**
         * Method that returns an Intent to load this Activity
         */
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this) //binding view to this activity for easy handling

        //initialise dependency injection
        initialiseDependency()
        userComponent!!.inject(this)

        setUpAdapter() //setting up recycler view to display items in list

        presenter.initialise() //load presenter for this activity
        presenter.view = this
    }

    /**
     * Method that initialises and attach adapter to recycler view
     */
    private fun setUpAdapter(){
        vehicleAdapter = VehicleAdapter(this)
        userRecyclerView.adapter = vehicleAdapter
        userRecyclerView.layoutManager = LinearLayoutManager(this)

        vehicleAdapter!!.onVehicleClickListener = object : VehicleAdapter.OnVehicleClickListener {
            override fun onCallDealer(dealerNumber: String) {
                presenter.callVehicleDealer(dealerNumber)
            }

            override fun onVehicleSelected(userModel: VehicleListModel) {

            }
        }
    }

    /**
     * Method to initialise dependency injection for this activity
     */
    private fun initialiseDependency(){
        userComponent = DaggerUserComponent.builder()
            .applicationComponent(CARFAXApplication.applicationComponent)
            .vehicleModule(VehicleModule())
            .build()
    }

    override fun renderVehicleList(vehicleList: ArrayList<VehicleListModel>) {
        vehicleAdapter!!.vehicleList = vehicleList
        vehicleAdapter!!.notifyDataSetChanged()
    }


    override fun showMessage(message: String) {
        Snackbar.make(coordinatorLayout,message,Snackbar.LENGTH_SHORT).show()
    }

    override val getCurrentSDKVersion: Int
        get() = Build.VERSION.SDK_INT

    override fun isPermissionGranted(s: String): Boolean {
        return PermissionChecker.checkSelfPermission(this,s) == PackageManager.PERMISSION_GRANTED
    }

    override fun requestPermission() {
        requestPermissions(arrayOf("android.permission.CALL_PHONE"), 30)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        presenter.requestPermissionResult(requestCode, permissions, grantResults)
    }


    override fun callDealer(dealerNumber: String) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:$dealerNumber")
        startActivity(callIntent)
    }



}
