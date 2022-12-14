package com.example.tailormeasure.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SizeBody(
    @PrimaryKey(autoGenerate = false)
    val name_of_body: String,
    val phone: String,
    val dor_gardan: Float,
    val sar_shane: Float,
    val karor_jolo: Float,
    val karor_posht: Float,
    val ghad_balatane_jolo: Float,
    val ghad_balatane_posht: Float,
    val ghad_sine: Float,
    val fasele_sine: Float,
    val dor_sine: Float,
    val dor_kamar: Float,
    val dor_basan: Float,
    val dor_bazo: Float,
    val dor_moch: Float,
    val ghad_astin: Float,
    val ghad_lebas: Float,
    val bazie_yaghe: Float,
    val ghad_basan: Float,
    val dor_halghe_astin: Float,
    val dor_ran: Float,
    val dor_zano: Float,
    val dor_damPa: Float,
    val ghad_shalvar: Float,
    val ghad_zano: Float,
    val anforShor: Float,
    val antijanp: Float,
    val baramadegie_basan: Float,
    val weight: Float,
    val ghad : Float

)
