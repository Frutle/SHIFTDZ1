package com.example.cwaetheritywaether.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cwaetheritywaether.domain.Town
import com.example.cwaetheritywaether.domain.GetTownsUseCase

class ListViewModel(private val  GetTownsUseCase: GetTownsUseCase) :ViewModel() {

    val townsList = MutableLiveData<List<Town>>()

    fun loadTowns(){

        val towns = GetTownsUseCase()

        townsList.value = towns
    }
}