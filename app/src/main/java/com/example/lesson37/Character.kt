package com.example.lesson37

import java.io.Serializable

data class Character(var image:String? = null, var name: String? = "Имя неизвестно", var isAlive: String? = "Dead" ):Serializable
