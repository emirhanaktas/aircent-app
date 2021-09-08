package com.epa.aircent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.epa.aircent.R
import com.epa.aircent.adapter.AirlinesAdapter
import com.epa.aircent.adapter.DestinationAdapter
import com.epa.aircent.model.AirlinesTypes
import com.epa.aircent.model.DestinationTypes
import com.epa.aircent.retrofit.retro
import kotlinx.android.synthetic.main.fragment_airplanes.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AirlinesFragment : Fragment(), AirlinesAdapter.Listener {

    private var param1: String? = null
    private var param2: String? = null
    private var airlinesModel: ArrayList<AirlinesTypes.Airline>? = null
    private var airlinesViewAdapter: AirlinesAdapter? = null

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

        val service = retro.getRetrofit()
        val call = service?.getAirlinesTypes()

        if (call != null) {
            call.enqueue(object: Callback<AirlinesTypes> {
                override fun onResponse(
                    call: Call<AirlinesTypes>,
                    response: Response<AirlinesTypes?>
                ) {

                    if (response.isSuccessful){
                        response.body()?.let {
                            airlinesModel = ArrayList(it.airlines)

                            airlinesModel?.let {
                                airlinesViewAdapter = AirlinesAdapter(it,this@AirlinesFragment )
                                recyclerView.adapter = airlinesViewAdapter
                            }

                        }
                    }
                }

                override fun onFailure(call: Call<AirlinesTypes>, t: Throwable) {
                    error("error")
                }

            })
        }


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_airlines, container, false)
    }

    companion object {


        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AirlinesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemClick(airlinesTypes: AirlinesTypes.Airline) {

    }
}