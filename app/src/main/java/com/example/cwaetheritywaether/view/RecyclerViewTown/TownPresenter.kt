package com.example.cwaetheritywaether.view.RecyclerViewTown

import com.example.cwaetheritywaether.BasePresenter
import com.example.cwaetheritywaether.data.TownRepository
import com.example.cwaetheritywaether.model.Town

class TownPresenter(private val repository: TownRepository) : BasePresenter<TownView>() {

    fun onViewResumed(){
        val townList = repository.getTowns()

        view?.bindTownList(townList)
    }

    fun onTownClicked(town: Town){
        view?.openTownDetailsScreen(town.id)
    }
}