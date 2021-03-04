package com.example.cwaetheritywaether.domain

class GetTownUseCase(private val repository: TownRepository) {

    operator fun invoke(id: Long): Town? = repository.getTown(id)
}