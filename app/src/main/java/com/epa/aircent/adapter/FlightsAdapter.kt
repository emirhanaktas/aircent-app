package com.epa.aircent.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.epa.aircent.databinding.FragmentFlightsBinding
import com.epa.aircent.databinding.RowAirlinesBinding
import com.epa.aircent.databinding.RowFlightsBinding
import com.epa.aircent.model.DestinationTypes
import com.epa.aircent.model.FlightsTypes

class FlightsAdapter (private val flightsList: ArrayList<FlightsTypes.Flight>, private val listener: FlightsAdapter.Listener):
    RecyclerView.Adapter<FlightsAdapter.RowHolder>() {

    interface Listener{
        fun onItemClick(flightsTypes: FlightsTypes.Flight)
    }

    class RowHolder(val binding: RowFlightsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(flightsTypes: FlightsTypes.Flight, position: Int, listener: FlightsAdapter.Listener){

            itemView.setOnClickListener{
                 listener.onItemClick(flightsTypes)
             }

            binding.flightsName.text = "Fligth Name: " + flightsTypes.flightName
            binding.gateNumber.text = "Gate: " + flightsTypes.gate.toString()
            binding.aircraftName.text = "Aircraft: " + flightsTypes.aircraftType?.iataMain.toString()
            binding.depatureTime.text = "Depature: " + flightsTypes.scheduleDate

         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        return RowHolder(RowFlightsBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(flightsList[position], position, listener)
    }

    override fun getItemCount(): Int {
        return flightsList.count()
    }

}