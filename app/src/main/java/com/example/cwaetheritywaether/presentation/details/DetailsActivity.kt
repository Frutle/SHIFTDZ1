package com.example.cwaetheritywaether.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cwaetheritywaether.R
import com.example.cwaetheritywaether.domain.Town
import com.example.cwaetheritywaether.presentation.weather.FragmentWeather

class DetailsActivity : AppCompatActivity(){

    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private val viewModel: DetailViewModel by viewModels{
        val id = intent.getLongExtra(EXTRA_ID,0)
        DetailViewModelFactory(id)
    }

    private lateinit var townName: TextView
    private lateinit var townTemperature: TextView
    private lateinit var townBreeze: TextView
    private lateinit var townCloudCover: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        viewModel.town.observe(this, ::bindTown)
        viewModel.closeScreenEvent.observe(this,{closeScreen()})
        initViews()
    }

    private fun initViews() {
            townName = findViewById(R.id.nameTown)
            townTemperature = findViewById(R.id.townTemp)
            initFragment()
            townBreeze = findViewById(R.id.tomorrow)
            townCloudCover = findViewById(R.id.cloudcover)
        }

        fun bindTown(town: Town) {
        townName.text = getString(R.string.name_format, town.townName)
        townTemperature.text = getString(R.string.temperature_format, town.temperature)
        townBreeze.text = getString(R.string.breeze_format, town.breeze)
        townCloudCover.text = getString(R.string.cloud_cover_format, town.cloudCover)
    }

    fun initFragment(){
            var fragment = FragmentWeather.newInstance()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment!!,"fragment-tag")
                .commit();
        }

    fun closeScreen() {
        finish()
    }

}