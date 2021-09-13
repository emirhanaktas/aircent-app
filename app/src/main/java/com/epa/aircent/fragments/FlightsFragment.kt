package com.epa.aircent.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.epa.aircent.fragments.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import com.epa.aircent.R
import com.epa.aircent.adapter.DestinationAdapter
import com.epa.aircent.adapter.FlightsAdapter
import com.epa.aircent.model.FlightsTypes
import com.epa.aircent.retrofit.retro
import kotlinx.android.synthetic.main.fragment_airplanes.*
import kotlinx.android.synthetic.main.fragment_airplanes.recyclerView
import kotlinx.android.synthetic.main.fragment_flights.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FlightsFragment : Fragment(), FlightsAdapter.Listener {
    private var param1: String? = null
    private var param2: String? = null

    private var flightsModel: ArrayList<FlightsTypes.Flight>? = null
    private var flightsViewAdapter: FlightsAdapter? = null
    var Flayout : ConstraintSet.Layout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Flights"

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val service = retro.getRetrofit()
        val call = service?.getFlightsTypes()

        if (call != null) {
            call.enqueue(object: Callback<FlightsTypes> {
                override fun onResponse(

                    call: Call<FlightsTypes>,
                    response: Response<FlightsTypes?>

                ) {

                    if (response.isSuccessful){
                        response.body()?.let {

                            flightsModel = ArrayList(it.flights)

                            flightsModel?.let {
                                flightsViewAdapter = FlightsAdapter(it,this@FlightsFragment )
                                recyclerView.adapter = flightsViewAdapter

                            }
                        }
                    }
                }

                override fun onFailure(call: Call<FlightsTypes>, t: Throwable) {
                    error("error")
                }

            })

        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flights, container, false) }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FlightsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



    override fun onItemClick(flightsTypes: FlightsTypes.Flight) {

    }

}