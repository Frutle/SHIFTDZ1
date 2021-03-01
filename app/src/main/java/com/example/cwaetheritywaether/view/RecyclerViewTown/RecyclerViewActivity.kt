package com.example.cwaetheritywaether.view.RecyclerViewTown

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cwaetheritywaether.App
import com.example.cwaetheritywaether.R
import com.example.cwaetheritywaether.model.Town
import com.example.cwaetheritywaether.view.details.DetailsActivity


class RecyclerViewActivity : AppCompatActivity() ,TownView {

    private val presenter by lazy { TownPresenter(repository = (application as App).TownRepository) }

    private lateinit var townList: RecyclerView

    private lateinit var toolBar: Toolbar

    private val adapter = TownAdapter{
        DetailsActivity.start(this, it.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)

        toolBar = (findViewById(R.id.toolbar) as Toolbar?)!!
        setSupportActionBar(toolBar)

        townList = findViewById(R.id.ListTown)
        townList.layoutManager = LinearLayoutManager(this)
        townList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        townList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.onViewResumed()
    }

    override fun bindTownList(list: List<Town>) {
        adapter.town = list
    }

    override fun openTownDetailsScreen(townId: Long) {
        DetailsActivity.start(this,townId)
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }
}