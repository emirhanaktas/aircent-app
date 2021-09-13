package com.epa.aircent.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.epa.aircent.R
import com.epa.aircent.adapter.AircentAdapter

import com.epa.aircent.databinding.ActivityMainBinding
import com.epa.aircent.fragments.*
import com.epa.aircent.model.AircraftTypes
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_airplanes.*


class MainActivity : AppCompatActivity(), AircentAdapter.Listener{


    lateinit var binding: ActivityMainBinding
   // private val BASE_URL = "https://api.schiphol.nl/"
   // private var aircentModel: ArrayList<AircentModel>? = null
   // private var aircentViewAdapt: AircentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //https://api.schiphol.nl/public-flights/aircrafttypes
        //b09b05ce272fbffce2189348ae86ed3e

        val airplanesFragment = AirplanesFragment()
        val airlinesFragment = AirlinesFragment()
        val destinationsFragment = DestinationsFragment()
        val flightsFragment = FlightsFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(airplanesFragment)

        bottom_navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.ic_airplanes -> makeCurrentFragment(airplanesFragment)
                R.id.ic_airlines -> makeCurrentFragment(airlinesFragment)
                R.id.ic_destination -> makeCurrentFragment(destinationsFragment)
                R.id.ic_flights -> makeCurrentFragment(flightsFragment)
                R.id.ic_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }

    //val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

   //recyclerView.layoutManager =  layoutManager

        loadData()

    }
    private fun loadData(){

      /*  val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
      val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
  */
       /* val service = retrofit.create(AircentApi::class.java)
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
                                aircentViewAdapt = AircentAdapter(it,this@MainActivity )
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
        } */
    }

    private  fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

    override fun onItemClick(aircraftTypes: AircraftTypes.AircraftType) {
            //Toast.makeText("this", "Clicked: ${aircentModel.longDescription}",Toast.LENGTH_LONG).show()
    }


}