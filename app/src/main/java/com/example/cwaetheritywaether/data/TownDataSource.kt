package com.example.cwaetheritywaether.data

import com.example.cwaetheritywaether.domain.Town

interface TownDataSource {

    fun getTowns(): List<Town>

    fun getTown(id: Long): Town?

    fun setTown(town: Town)
}