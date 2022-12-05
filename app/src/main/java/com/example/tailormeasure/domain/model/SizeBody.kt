package com.example.tailormeasure.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SizeBody(
    @PrimaryKey(autoGenerate = false)
    val name_of_body: String,
    val phone: String,
    val dor_gardan: Int,
    val dor_sine: Int,
    val dor_bazo: Int,
    val dor_kamar: Int,
    val dor_basan: Int

)
