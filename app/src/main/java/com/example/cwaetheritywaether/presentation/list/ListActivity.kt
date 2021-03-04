package com.example.cwaetheritywaether.presentation.list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cwaetheritywaether.R
import com.example.cwaetheritywaether.domain.Town
import com.example.cwaetheritywaether.presentation.list.details.DetailsActivity



class ListActivity : AppCompatActivity()  {

    private val viewModel: ListViewModel by viewModels {
        ListViewModelFactory()
    }

    private lateinit var townList: RecyclerView

    private lateinit var toolBar: Toolbar

    private val adapter = TownAdapter{
        DetailsActivity.start(this, it.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.townsList.observe(this,::bindTownsList)

        toolBar = (findViewById(R.id.toolbar) as Toolbar?)!!
        setSupportActionBar(toolBar)

        townList = findViewById(R.id.ListTown)
        townList.layoutManager = LinearLayoutManager(this)
        townList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        townList.adapter = adapter
    }

    private fun bindTownsList(list: List<Town>) {
        adapter.town = list
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadTowns()
    }

}