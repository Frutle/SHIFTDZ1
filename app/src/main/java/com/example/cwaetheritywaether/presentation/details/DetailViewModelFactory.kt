package com.example.cwaetheritywaether.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cwaetheritywaether.data.TownLocalDataSourceImpl
import com.example.cwaetheritywaether.data.TownRepositoryImpl
import com.example.cwaetheritywaether.domain.GetTownUseCase
import com.example.cwaetheritywaether.domain.SetTownUseCase

class DetailViewModelFactory(private val id: Long) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val townDataSource = TownLocalDataSourceImpl()
        val townRepository = TownRepositoryImpl(townDataSource)
        val getTownUseCase = GetTownUseCase(townRepository)

        return modelClass
            .getConstructor(
                GetTownUseCase::class.java,
                Long::class.java
            )
            .newInstance(getTownUseCase,id)
    }

}