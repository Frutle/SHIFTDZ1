package com.example.cwaetheritywaether.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cwaetheritywaether.App
import com.example.cwaetheritywaether.R
import com.example.cwaetheritywaether.data.townRepository
import com.example.cwaetheritywaether.view.details.DetailsActivity
import com.example.cwaetheritywaether.view.details.TownAdapter


class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var townRepository: townRepository

    private lateinit var townList: RecyclerView

    private val adapter = TownAdapter{
        DetailsActivity.start(this, it.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        townRepository = (application as App).townRepository

        townList = findViewById(R.id.ListTown)
        townList.layoutManager = LinearLayoutManager(this)
        townList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        townList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.town = townRepository.getTowns()
    }
}