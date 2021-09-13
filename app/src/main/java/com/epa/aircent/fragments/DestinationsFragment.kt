package com.epa.aircent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.epa.aircent.R
import com.epa.aircent.adapter.AircentAdapter
import com.epa.aircent.adapter.DestinationAdapter
import com.epa.aircent.model.AircraftTypes
import com.epa.aircent.model.DestinationTypes
import com.epa.aircent.retrofit.retro
import kotlinx.android.synthetic.main.fragment_airplanes.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DestinationsFragment : Fragment(), DestinationAdapter.Listener {

    private var param1: String? = null
    private var param2: String? = null
    private var destinationModel: ArrayList<DestinationTypes.Destination>? = null
    private var destinationViewAdapter: DestinationAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Destinations"
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
        val call = service?.getDestinationTypes()

        if (call != null) {
            call.enqueue(object: Callback<DestinationTypes> {
                override fun onResponse(
                    call: Call<DestinationTypes>,
                    response: Response<DestinationTypes?>
                ) {

                    if (response.isSuccessful){
                        response.body()?.let {
                            destinationModel = ArrayList(it.destinations)

                            destinationModel?.let {
                                destinationViewAdapter = DestinationAdapter(it,this@DestinationsFragment )
                                recyclerView.adapter = destinationViewAdapter
                            }

                        }
                    }
                }

                override fun onFailure(call: Call<DestinationTypes>, t: Throwable) {
                    error("error")
                }

            })
        }


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destinations, container, false)
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            DestinationsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemClick(destinationTypes: DestinationTypes.Destination) {

    }
}