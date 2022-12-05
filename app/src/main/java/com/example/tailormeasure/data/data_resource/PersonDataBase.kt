package com.example.tailormeasure.data.data_resource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tailormeasure.domain.model.Dress
import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.domain.model.SizeBody

@Database(
    entities = [
        Person::class,
        Dress::class,
        SizeBody::class
    ],
    version = 2
)
abstract class PersonDataBase : RoomDatabase() {

    abstract val dao : PersonDao

}