package com.example.cwaetheritywaether.domain

interface TownRepository {

    fun getTowns(): List<Town>

    fun getTown(id: Long): Town?

    fun setTown(town: Town)
}