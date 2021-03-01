package com.example.cwaetheritywaether.view.details

import com.example.cwaetheritywaether.BaseView
import com.example.cwaetheritywaether.model.Town

interface DetailView : BaseView{
    fun bindTown(town: Town)

    fun closeScreen()
}