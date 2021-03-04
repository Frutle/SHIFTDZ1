package com.example.cwaetheritywaether.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cwaetheritywaether.data.TownLocalDataSourceImpl
import com.example.cwaetheritywaether.data.TownRepositoryImpl
import com.example.cwaetheritywaether.domain.GetTownUseCase
import com.example.cwaetheritywaether.domain.GetTownsUseCase

class ListViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val townDataSource = TownLocalDataSourceImpl()
        val townRepository = TownRepositoryImpl(townDataSource)
        val getTownsUseCase = GetTownsUseCase(townRepository)

        return modelClass
            .getConstructor(GetTownsUseCase::class.java)
            .newInstance(getTownsUseCase)
    }
}