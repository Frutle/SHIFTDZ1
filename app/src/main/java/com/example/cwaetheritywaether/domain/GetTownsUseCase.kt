package com.example.cwaetheritywaether.domain

class GetTownsUseCase(private val repository: TownRepository) {

    operator fun invoke(): List<Town> = repository.getTowns()
}