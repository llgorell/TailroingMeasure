package com.example.tailormeasure.domain.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.domain.model.SizeBody

data class PersonAndSizeBody(
    @Embedded val person: Person,
    @Relation(
        parentColumn = "phone",
        entityColumn = "phone"
    )
    val sizeBody: SizeBody
)
