package com.epa.aircent.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.epa.aircent.databinding.RowLayoutBinding
import com.epa.aircent.model.AircraftTypes
import kotlinx.android.synthetic.main.row_layout.view.*

class AircentAdapter(private val aircentList: ArrayList<AircraftTypes.AircraftType>, private val listener: AircentAdapter.Listener):
    RecyclerView.Adapter<AircentAdapter.RowHolder>() {


    interface  Listener{
        fun  onItemClick(aircraftTypes: AircraftTypes.AircraftType)
    }
    class RowHolder(val binding: RowLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(aircraftTypes: AircraftTypes.AircraftType, position: Int, listener: Listener ){
            itemView.setOnClickListener{
                listener.onItemClick(aircraftTypes)
            }
            binding.planeName.text = aircraftTypes.longDescription
            binding.planeNumber.text = aircraftTypes.iataMain.toString()
          //  itemView.plane_name.text = aircraftTypes.longDescription
          //  itemView.plane_number.text = aircraftTypes.iataMain.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {



        //val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return  RowHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(aircentList[position], position, listener)


    }

    override fun getItemCount(): Int {
        return aircentList.count()
    }

}









