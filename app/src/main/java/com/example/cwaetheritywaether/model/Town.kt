package com.example.cwaetheritywaether.model

data class Town(val id : Long,
                val townName: String,
                var temperature : Long,
                val breeze : String,
                val cloudCover : String) {
}