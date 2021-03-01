package com.example.cwaetheritywaether.view.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cwaetheritywaether.App
import com.example.cwaetheritywaether.R
import com.example.cwaetheritywaether.data.TownRepository

class DetailsActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private lateinit var TownRepository: TownRepository

    private lateinit var townName: TextView
    private lateinit var townTemperature: TextView
    private lateinit var townBreeze: TextView
    private lateinit var townCloudCover: TextView
    private lateinit var imputTemperature: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        TownRepository = (application as App).TownRepository

        initViews()

    }

    private fun initViews() {
        val id = intent.getLongExtra(EXTRA_ID, 0)
        val town = TownRepository.getTown(id)

        if (town != null) {
            townName = findViewById(R.id.nameTown)
            townTemperature = findViewById(R.id.townTemp)
            townBreeze = findViewById(R.id.breeze)
            townCloudCover = findViewById(R.id.cloudcover)
            imputTemperature = findViewById(R.id.temperatureImput)

            saveButton = findViewById(R.id.saveButton)

            townName.text = getString(R.string.name_format, town.townName)
            townTemperature.text = getString(R.string.temperature_format, town.temperature)
            townBreeze.text = getString(R.string.breeze_format,town.breeze)
            townCloudCover.text = getString(R.string.cloud_cover_format,town.cloudCover)

            saveButton.setOnClickListener {
                town.temperature = imputTemperature.text.toString().toLong()
                TownRepository.setTown(town)
                finish()
            }
        } else {
            finish()
        }
    }


}