package com.carafax.views.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.carafax.R
import com.carafax.models.VehicleListModel
import com.squareup.picasso.Picasso
import kotlin.collections.ArrayList

/**
 * class to load user list data
 */
class VehicleAdapter(private val context: Context) : RecyclerView.Adapter<VehicleAdapter.UserAdapterViewHolder>() {

    var vehicleList: ArrayList<VehicleListModel> = ArrayList()
    var onVehicleClickListener : OnVehicleClickListener? = null

    interface OnVehicleClickListener{
       fun onVehicleSelected(vehicleListModel: VehicleListModel)
       fun onCallDealer(dealerNumber : String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapterViewHolder {
      val view : View = LayoutInflater.from(parent.context).inflate(R.layout.row_vehicle,parent,false)
        return UserAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
       return vehicleList.size
    }

    override fun onBindViewHolder(holder: UserAdapterViewHolder, position: Int) {
        val vehicleModel : VehicleListModel = vehicleList[position]

        //use picasso to download image
        Log.e("photo_url","_"+vehicleModel.vehiclePhotoUrl)
        Picasso.with(context).load(vehicleModel.vehiclePhotoUrl).fit().into(holder.vehicleImageView)

        holder.callDealerButton.setOnClickListener { vehicleModel.vehicleCarDealerNumber?.let { it1 ->
            onVehicleClickListener?.onCallDealer(
                it1
            )
        } }

        holder.itemView.setOnClickListener{ onVehicleClickListener?.onVehicleSelected(vehicleModel) }
    }

    inner class UserAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.vehicle_image_view)
        lateinit var vehicleImageView : ImageView

        @BindView(R.id.vehicle_info_text_view)
        lateinit var vehicleInfoTextView : TextView

        @BindView(R.id.vehicle_price_text_view)
        lateinit var vehiclePriceTextView: TextView

        @BindView(R.id.vehicle_location_text_view)
        lateinit var vehicleLoctionTextView : TextView

        @BindView(R.id.call_dealer_button)
        lateinit var callDealerButton : Button

        init {
            ButterKnife.bind(this,itemView)
        }
    }
}