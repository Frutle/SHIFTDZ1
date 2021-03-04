package com.example.cwaetheritywaether.data

import com.example.cwaetheritywaether.domain.TownRepository
import com.example.cwaetheritywaether.domain.Town

class TownRepositoryImpl(private val townDataSource: TownDataSource) : TownRepository {

    override fun getTowns(): List<Town> = townDataSource.getTowns()

    override fun getTown(id: Long): Town? = townDataSource.getTown(id)

    override fun setTown(town: Town) {
        townDataSource.setTown(town)
    }
}