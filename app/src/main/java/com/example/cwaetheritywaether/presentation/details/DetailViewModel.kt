package com.example.cwaetheritywaether.presentation.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cwaetheritywaether.domain.GetTownUseCase
import com.example.cwaetheritywaether.domain.SetTownUseCase
import com.example.cwaetheritywaether.domain.Town
import com.example.cwaetheritywaether.presentation.LiveEvent

class DetailViewModel(
    getTownUseCase: GetTownUseCase,
    id: Long) : ViewModel() {

    val town = MutableLiveData<Town>()

    val closeScreenEvent = LiveEvent()

    init {
        val town = getTownUseCase(id)

        if(town != null){
            this.town.value = town!!
        } else {
            closeScreenEvent(Unit)
        }
    }
}