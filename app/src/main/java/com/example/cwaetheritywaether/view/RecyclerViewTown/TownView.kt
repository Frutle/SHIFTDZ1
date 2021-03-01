package com.example.cwaetheritywaether.view.RecyclerViewTown

import com.example.cwaetheritywaether.BaseView
import com.example.cwaetheritywaether.model.Town

interface TownView : BaseView {

    fun bindTownList(list: List<Town>)

    fun openTownDetailsScreen(townId: Long)
}