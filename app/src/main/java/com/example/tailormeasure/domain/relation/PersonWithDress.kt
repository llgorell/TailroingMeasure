package com.example.tailormeasure.domain.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.tailormeasure.domain.model.Dress
import com.example.tailormeasure.domain.model.Person

data class PersonWithDress(
    @Embedded val person: Person,
    @Relation(
        parentColumn = "phone",
        entityColumn = "phone"
    )
    val dresses : List<Dress>
)
