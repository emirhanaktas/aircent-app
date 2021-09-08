package com.epa.aircent.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.epa.aircent.databinding.RowDestinationBinding
import com.epa.aircent.databinding.RowLayoutBinding
import com.epa.aircent.model.AircraftTypes
import com.epa.aircent.model.DestinationTypes

class DestinationAdapter(private val destinationList: ArrayList<DestinationTypes.Destination>, private val listener: DestinationAdapter.Listener):
    RecyclerView.Adapter<DestinationAdapter.RowHolder>() {

    interface Listener{
        fun onItemClick(destinationTypes: DestinationTypes.Destination)
    }

    class RowHolder(val binding: RowDestinationBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(destinationTypes: DestinationTypes.Destination, position: Int, listener: DestinationAdapter.Listener){

            itemView.setOnClickListener{
                listener.onItemClick(destinationTypes)
            }
            binding.publicName.text = destinationTypes.publicName?.english.toString()
            binding.countryName.text = destinationTypes.country
            binding.iadataName.text = destinationTypes.iata.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        return RowHolder(RowDestinationBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(destinationList[position], position, listener)
    }

    override fun getItemCount(): Int {
      return destinationList.count()
    }
}