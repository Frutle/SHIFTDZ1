package com.example.cwaetheritywaether.view.details

import com.example.cwaetheritywaether.BasePresenter
import com.example.cwaetheritywaether.data.TownRepository
import com.example.cwaetheritywaether.model.Town

class DetailPresenter(
    private val repository: TownRepository,
    private val townId: Long) : BasePresenter<DetailView>(){

    override fun onViewAttached() {
        val town = repository.getTown(townId)

        if (town != null) {
            view?.bindTown(town)
        } else {
            view?.closeScreen()
        }
    }

    fun saveTown(town: Town) {
        repository.setTown(town)
        view?.closeScreen()
    }
}