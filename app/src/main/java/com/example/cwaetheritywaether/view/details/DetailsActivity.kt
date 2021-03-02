package com.example.cwaetheritywaether.view.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cwaetheritywaether.App
import com.example.cwaetheritywaether.R
import com.example.cwaetheritywaether.model.Town
import com.example.cwaetheritywaether.view.FragmentWeather

class DetailsActivity : AppCompatActivity(),DetailView {

    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private val presenter by lazy {
        DetailPresenter(
            repository = (application as App).TownRepository,
            townId = intent.getLongExtra(EXTRA_ID, 0)
        )
    }


    private lateinit var townName: TextView
    private lateinit var townTemperature: TextView
    private lateinit var townBreeze: TextView
    private lateinit var townCloudCover: TextView
//    private lateinit var imputTemperature: EditText
//    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initViews()

        presenter.attachView(this)

    }

    private fun initViews() {

            townName = findViewById(R.id.nameTown)
            townTemperature = findViewById(R.id.townTemp)
            initFragment()
            townBreeze = findViewById(R.id.tomorrow)
            townCloudCover = findViewById(R.id.cloudcover)
//            imputTemperature = findViewById(R.id.temperatureImput)
//
//            saveButton = findViewById(R.id.saveButton)

        }

    override fun bindTown(town: Town) {
        townName.text = getString(R.string.name_format, town.townName)

        townTemperature.text = getString(R.string.temperature_format, town.temperature)
        townBreeze.text = getString(R.string.breeze_format, town.breeze)
        townCloudCover.text = getString(R.string.cloud_cover_format, town.cloudCover)

//        saveButton.setOnClickListener {
//            town.temperature = imputTemperature.text.toString().toLong()
//            TownRepository.setTown(town)
//        }
    }

    fun initFragment(){
//        if(savedInstanceState == null)
            var fragment = FragmentWeather.newInstance()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment!!,"fragment-tag")
                .commit();
        }

    override fun closeScreen() {
        finish()
    }

//    private fun showAlertDialog() {
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Выберите город")
//        val editText = EditText(this)
//        editText.inputType = InputType.TYPE_CLASS_TEXT
//        builder.setView(editText)
//        builder.setPositiveButton(
//            R.string.go
//        ) { dialog, which -> changeTown(editText.text.toString()) }
//        builder.show()
//    }

//    fun changeTown(town: String?) {}

}