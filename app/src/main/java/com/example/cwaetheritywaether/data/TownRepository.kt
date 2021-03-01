package com.example.cwaetheritywaether.data

import com.example.cwaetheritywaether.model.Town

class TownRepository {

    private val city = mutableListOf(
        Town(5,"Томск",20,"5км.0/ч","Облачно"),
        Town(1,"Новосибирск",-30,"13.0км/ч","Небольшой снег"),
        Town(2,"Москва",30,"99.0км/ч","Сильный ветер"),
        Town(3,"Вологда",55,"13.0км/ч","Небольшой снег"),
        Town(4,"Ростов",5,"2.0км/ч","Облачно"),
    )

    fun getTowns() : List<Town> = city

    fun getTown(id: Long) : Town? = city.firstOrNull { it.id == id }

    fun setTown(town: Town) {
        val editedPersonIndex = city.indexOfFirst { it.id == town.id }
        if (editedPersonIndex >= 0) {
            city[editedPersonIndex] = town
        }
    }

    }
