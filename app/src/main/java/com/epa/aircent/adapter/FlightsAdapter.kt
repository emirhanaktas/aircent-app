package com.epa.aircent.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.ColorSpace
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.epa.aircent.R
import com.epa.aircent.databinding.RowFlightsBinding
import com.epa.aircent.fragments.FlightDetailsFragment
import com.epa.aircent.fragments.FlightsFragment
import com.epa.aircent.model.FlightsTypes
import com.epa.aircent.view.FlightDetailsActivity

class FlightsAdapter (private val flightsList: ArrayList<FlightsTypes.Flight>, private val listener: FlightsAdapter.Listener):
    RecyclerView.Adapter<FlightsAdapter.RowHolder>()  {



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

    override fun onBindViewHolder(holder: RowHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(flightsList[position], position, listener)
        val model = flightsList.get(position)

        holder.itemView.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?){


                val activity = v?.context as AppCompatActivity
                val flightDetailsFragment = FlightDetailsFragment()
/*
                activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.rec,flightDetailsFragment)
                    .addToBackStack(null)
                    .commit()

 */             var gFlightName : String = model.flightName.toString()
                var gIdNumber : String = model.id.toString()
                var gModelName : String = model.aircraftType?.iataSub.toString()
                var gIataCode : String = model.prefixIATA.toString()
                var gGate : String = model.gate.toString()
                var gFlightNumber: String = model.flightNumber.toString()
                var gTakeOff: String = model.scheduleDate.toString()
                var gLanding: String = model.actualLandingTime.toString()
                val intent = Intent(v.context, FlightDetailsActivity::class.java)
                intent.putExtra("gFlightName", gFlightName)
                intent.putExtra("gIdNumber", gIdNumber)
                intent.putExtra("gModelName", gModelName)
                intent.putExtra("gIataCode", gIataCode)
                intent.putExtra("gGate", gGate)
                intent.putExtra("gFlightNumber", gFlightNumber)
                intent.putExtra("gTakeOff", gTakeOff)
                intent.putExtra("gLanding", gLanding)
                v.context.startActivity(intent)

            }
        })

    }




    override fun getItemCount(): Int {
        return flightsList.count()
    }



}