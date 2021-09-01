package com.epa.aircent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.epa.aircent.R
import com.epa.aircent.adapter.AircentAdapter
import com.epa.aircent.model.AircentModel
import com.epa.aircent.retrofit.retro
import com.epa.aircent.service.AircentApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AirplanesFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var aircentModel: ArrayList<AircentModel>? = null
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

        val service = retro.retrofit.create(AircentApi::class.java)
        val call = service.getAircraftTypes()



        if (call != null) {
            call.enqueue(object : Callback<List<AircentModel>>{
                override fun onResponse(
                    call: Call<List<AircentModel>>,
                    response: Response<List<AircentModel>>
                ) {
                    if (response.isSuccessful){
                        response.body()?.let {
                            aircentModel = ArrayList(it)

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

                override fun onFailure(call: Call<List<AircentModel>>, t: Throwable) {

                }

            })
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_airplanes, container, false)

    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AirplanesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}


