package com.example.tailormeasure.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dress(

    @PrimaryKey(autoGenerate = true) val id : Int? = null,
    val name : String,
    val phone : String,
    val price : Long,
    val paid : Long,
    val account_balance : Long,
    val start_date : String,
    val delivery_date :String,
    val not_paid : Boolean

)
