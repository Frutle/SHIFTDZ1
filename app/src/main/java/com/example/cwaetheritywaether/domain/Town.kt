package com.example.cwaetheritywaether.domain

data class Town(val id : Long,
                val townName: String,
                var temperature : Long,
                val breeze : String,
                val cloudCover : String) {
}