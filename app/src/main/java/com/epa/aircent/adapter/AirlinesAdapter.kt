package com.epa.aircent.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.epa.aircent.databinding.RowAirlinesBinding
import com.epa.aircent.model.AirlinesTypes
import com.epa.aircent.model.DestinationTypes

class AirlinesAdapter(private val airlinesList: ArrayList<AirlinesTypes.Airline>, private val listener: AirlinesAdapter.Listener):
    RecyclerView.Adapter<AirlinesAdapter.RowHolder>()
{
    interface Listener{
        fun onItemClick(airlinesTypes: AirlinesTypes.Airline)
    }

    class RowHolder(val binding: RowAirlinesBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(airlinesTypes: AirlinesTypes.Airline,  position: Int, listener: AirlinesAdapter.Listener){

            itemView.setOnClickListener{
                listener.onItemClick(airlinesTypes)
            }
            binding.publicName.text = airlinesTypes.publicName.toString()
            binding.iataName.text = airlinesTypes.iata.toString()


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        return RowHolder(RowAirlinesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(airlinesList[position],position,listener)
    }

    override fun getItemCount(): Int {
       return airlinesList.count()
    }

}