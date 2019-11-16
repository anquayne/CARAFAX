package com.carafax.views.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.PermissionChecker
import butterknife.BindView
import butterknife.ButterKnife
import com.carafax.R
import com.carafax.models.VehicleListModel
import com.carafax.presenters.VehicleDetailsPresenter
import com.carafax.views.VehicleDetailsView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class VehicleDetailsActivity : BaseActivity(), VehicleDetailsView {

    private var presenter : VehicleDetailsPresenter? = null

    @BindView(R.id.coordinator_layout)
    lateinit var coordinatorLayout : CoordinatorLayout

    @BindView(R.id.vehicle_image_view)
    lateinit var vehicleImageView : ImageView

    @BindView(R.id.vehicle_info_text_view)
    lateinit var vehicleInfoTextView : TextView

    @BindView(R.id.vehicle_price_text_view)
    lateinit var vehiclePriceTextView: TextView

    @BindView(R.id.vehicle_location_text_view)
    lateinit var vehicleLoctionTextView : TextView

    companion object {
        /**
         * Method that returns an Intent to load this Activity
         */
        fun getCallingIntent(context: Context): Intent {
            Log.e("_launched","_data_no")
            return Intent(context, VehicleDetailsActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_details)
        ButterKnife.bind(this) //binding view to this activity for easy handling
        Log.e("_launched","_data")
        val vehicleModel : VehicleListModel? = intent.getSerializableExtra("vehicleModel") as VehicleListModel
        presenter = VehicleDetailsPresenter()
        presenter?.view = this
        vehicleModel?.let { presenter?.initialise(it) }?:showMessage("Something went wrong")
    }

    override fun renderVehicleDetails(vehicleListModel: VehicleListModel) {
        Picasso.with(this).load(vehicleListModel.vehiclePhotoUrl).fit().into(vehicleImageView)
    }

    override fun showMessage(message: String) {
        Snackbar.make(coordinatorLayout,message, Snackbar.LENGTH_SHORT).show()
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
        presenter?.requestPermissionResult(requestCode, permissions, grantResults)
    }

    @SuppressLint("MissingPermission")
    override fun callDealer(dealerNumber: String) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:$dealerNumber")
        startActivity(callIntent)
    }


}