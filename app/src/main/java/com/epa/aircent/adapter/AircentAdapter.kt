package com.epa.aircent.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.epa.aircent.R
import com.epa.aircent.fragments.AirplanesFragment
import com.epa.aircent.model.AircentModel
import kotlinx.android.synthetic.main.fragment_airplanes.view.*
import kotlinx.android.synthetic.main.row_layout.view.*

class AircentAdapter(private val aircentList: ArrayList<AircentModel>, private val listener: AircentAdapter.Listener):
    RecyclerView.Adapter<AircentAdapter.RowHolder>() {

    interface  Listener{
        fun  onItemClick(aircentModel: AircentModel)
    }
    class RowHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(aircentModel: AircentModel, position: Int, listener: Listener ){
            itemView.setOnClickListener{
                listener.onItemClick(aircentModel)
            }
            itemView.plane_name.text = aircentModel.longDescription
            itemView.plane_number.text = aircentModel.iataMain.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return  RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(aircentList[position], position, listener)
    }

    override fun getItemCount(): Int {
        return aircentList.count()
    }
}









