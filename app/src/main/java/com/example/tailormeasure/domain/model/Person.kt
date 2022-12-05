package com.example.tailormeasure.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    @PrimaryKey(autoGenerate = false)
    val phone : String,
    val name : String,
    val family : String,
    val inDebt : Boolean = false,
    val totalDebt : Long = 0
)
