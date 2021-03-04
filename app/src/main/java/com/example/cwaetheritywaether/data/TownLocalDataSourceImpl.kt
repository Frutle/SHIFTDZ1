package com.example.cwaetheritywaether.data

import com.example.cwaetheritywaether.domain.Town

class TownLocalDataSourceImpl : TownDataSource {

    private val city = mutableListOf(
        Town(0,"Томск",20,"5.0 км/ч","Облачно"),
        Town(1,"Новосибирск",-30,"13.0 км/ч","Небольшой снег"),
        Town(2,"Москва",30,"99.0 км/ч","Сильный ветер"),
        Town(3,"Вологда",55,"13.0 км/ч","Небольшой снег"),
        Town(4,"Ростов",5,"2.0 км/ч","Облачно"),
    )

    override fun getTowns() : List<Town> = city

    override fun getTown(id: Long): Town? = city.firstOrNull { it.id == id }

    override fun setTown(town: Town) {
        val editedPersonIndex = city.indexOfFirst { it.id == town.id }
        if (editedPersonIndex >= 0) {
            city[editedPersonIndex] = town
        }
    }
}