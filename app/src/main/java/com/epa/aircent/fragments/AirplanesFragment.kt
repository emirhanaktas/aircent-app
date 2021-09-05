package com.epa.aircent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.epa.aircent.R
import com.epa.aircent.adapter.AircentAdapter
import com.epa.aircent.databinding.FragmentAirplanesBinding
import com.epa.aircent.model.AircraftTypes
import com.epa.aircent.retrofit.retro
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_airplanes.*
import kotlinx.android.synthetic.main.fragment_airplanes.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AirplanesFragment: Fragment(), AircentAdapter.Listener {

    lateinit var binding: FragmentAirplanesBinding
    private var param1: String? = null
    private var param2: String? = null
    private var aircentModel: ArrayList<AircraftTypes.AircraftType>? = null
    private var aircentViewAdapt: AircentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)



        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }



    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        //    val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
        //recyclerView.layoutManager =  layoutManager

        val service = retro.getRetrofit()
        val call = service?.getAircraftTypes()




        if (call != null) {
            call.enqueue(object: Callback<AircraftTypes.AircraftType>{
                override fun onResponse(
                    call: Call<AircraftTypes.AircraftType>,
                    response: Response<AircraftTypes.AircraftType?>
                ) {

                    if (response.isSuccessful){
                        response.body()?.let {
                            aircentModel = ArrayList()

                            aircentModel?.let {
                                aircentViewAdapt = AircentAdapter(it,this@AirplanesFragment )
                                recyclerView.adapter = aircentViewAdapt
                            }

                            /*for (aircentModel: AircentModel in aircentModel!!){
                               println(aircentModel.longDescription)
                               println(aircentModel.iataMain)
                           }
                            */
                        }
                    }
                }

                override fun onFailure(call: Call<AircraftTypes.AircraftType>, t: Throwable) {
                    error("error")
                }

            })
        }

        return inflater.inflate(R.layout.fragment_airplanes, container, false)
        return binding.root
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AirplanesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemClick(aircraftTypes: AircraftTypes.AircraftType) {

    }

}



