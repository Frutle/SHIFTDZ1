package com.example.cwaetheritywaether.domain

class SetTownUseCase(private val townRepository: TownRepository) {

    operator fun invoke(town: Town){
        townRepository.setTown(town)
    }
}