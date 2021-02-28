package com.example.cwaetheritywaether.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cwaetheritywaether.R
import android.annotation.SuppressLint
import android.location.Location
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.json.JSONObject


class FragmentWeather : Fragment() {

    companion object{
        fun newInstance(): FragmentWeather? {
            return FragmentWeather()
        }
    }

    private lateinit var today: TextView
    private lateinit var tomorrow: TextView
    private lateinit var thisTown: Button
    var weather_url1 :String =""

    var api_id1 = "048f9fee82644297b2418d88cbb19722"

    private lateinit var textView: TextView
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var bt :Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)

//        today = view.findViewById(R.id.today)
//        tomorrow = view.findViewById(R.id.tomorrow)

        textView = view.findViewById(R.id.textView)
        bt = view.findViewById(R.id.bt)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity!!)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt.setOnClickListener {
            obtainLocation()
        }

    }

    @SuppressLint("MissingPermission")
    private fun obtainLocation(){
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                weather_url1 = "https://api.weatherbit.io/v2.0/current?" + "lat=" + location?.latitude +"&lon="+ location?.longitude + "&key="+ api_id1
                getTemp()
            }
    }

    fun getTemp() {

        val queue = Volley.newRequestQueue(activity)
        val url: String = weather_url1
        val stringReq = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->

                val obj = JSONObject(response)
                val arr = obj.getJSONArray("data")
                val obj2 = arr.getJSONObject(0)

                textView.text = obj2.getString("temp")+" Температура в  "+obj2.getString("city_name")
            },
            Response.ErrorListener { textView!!.text = "Ошибка" })
        queue.add(stringReq)
    }
}