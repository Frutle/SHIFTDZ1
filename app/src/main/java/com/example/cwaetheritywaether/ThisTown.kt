//package com.example.cwaetheritywaether
//
//import android.annotation.SuppressLint
//import android.location.Location
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.TextView
//import com.android.volley.Request
//import com.android.volley.Response
//import com.android.volley.toolbox.StringRequest
//import com.android.volley.toolbox.Volley
//import com.google.android.gms.location.FusedLocationProviderClient
//import com.google.android.gms.location.LocationServices
//import org.json.JSONObject
//
//class ThisTown : AppCompatActivity() {
//
//    var weather_url1 :String =""
//
//    var api_id1 = "048f9fee82644297b2418d88cbb19722"
//
//    private lateinit var textView: TextView
//    private lateinit var fusedLocationClient: FusedLocationProviderClient
//    private lateinit var bt :Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        textView = findViewById(R.id.textView)
//        bt = findViewById(R.id.bt)
//
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//
//        bt.setOnClickListener {
//            obtainLocation()
//        }
//    }
//
//    @SuppressLint("MissingPermission")
//    private fun obtainLocation(){
//        fusedLocationClient.lastLocation
//            .addOnSuccessListener { location: Location? ->
//                weather_url1 = "https://api.weatherbit.io/v2.0/current?" + "lat=" + location?.latitude +"&lon="+ location?.longitude + "&key="+ api_id1
//                getTemp()
//            }
//    }
//
//    fun getTemp() {
//
//        val queue = Volley.newRequestQueue(this)
//        val url: String = weather_url1
//        val stringReq = StringRequest(
//            Request.Method.GET, url,
//            Response.Listener<String> { response ->
//
//                val obj = JSONObject(response)
//                val arr = obj.getJSONArray("data")
//                val obj2 = arr.getJSONObject(0)
//
//                textView.text = obj2.getString("temp")+" емпература в  "+obj2.getString("city_name")
//            },
//            Response.ErrorListener { textView!!.text = "Ошибка" })
//        queue.add(stringReq)
//    }
//}