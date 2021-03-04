package com.example.cwaetheritywaether.presentation

class LiveEvent : SingleLiveEvent<Unit>() {

    operator fun invoke(){
        this.value = Unit
    }
}