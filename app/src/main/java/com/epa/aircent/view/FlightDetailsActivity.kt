package com.epa.aircent.view

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentManager
import com.epa.aircent.R
import com.epa.aircent.fragments.FlightDetailsFragment
import kotlinx.android.synthetic.main.activity_flight_details.*

class FlightDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_details)

        val btn = findViewById<Button>(R.id.item_image)
         
        btn?.setOnClickListener() {


            var url = "https://www.skyscanner.com.tr/";
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))

        }


        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        var intent = intent
        val aFlightName = intent.getStringExtra("gFlightName")
        val aIdNumber = intent.getStringExtra("gIdNumber")
        val aModelName = intent.getStringExtra("gModelName")
        val aIataCode = intent.getStringExtra("gIataCode")
        val aGate = intent.getStringExtra("gGate")
        val aFlightNumber = intent.getStringExtra("gFlightNumber")
        val aTakeOff = intent.getStringExtra("gTakeOff")
        val aLanding = intent.getStringExtra("gLanding")
        actionBar.setTitle("Flight Details")
        flight_name.text = "Flight Name: " + aFlightName
        id_number.text = "ID: " + aIdNumber
        model_name.text = "Model: " + aModelName
        iata_code.text = aIataCode
        gate.text = aGate
        flight_number.text ="IATA Code: " +  aFlightNumber
        take_off.text = aTakeOff
        landing.text = aLanding


    }
}