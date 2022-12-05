package com.example.tailormeasure.domain.repository

import com.example.tailormeasure.domain.model.Dress
import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.domain.model.SizeBody
import com.example.tailormeasure.domain.relation.PersonAndSizeBody
import com.example.tailormeasure.domain.relation.PersonWithDress
import kotlinx.coroutines.flow.Flow

interface PersonRepository {

    fun getPersons() : Flow<List<Person>>

    fun getDressesByPhone(phone : String) : Flow<List<PersonWithDress>>

    fun searchQuery(query : String) : Flow<List<Person>>

    suspend fun getSizeBody(phone: String) : PersonAndSizeBody?

    suspend fun insertPerson(person: Person)

    suspend fun insertSizeBody(sizeBody: SizeBody)

    suspend fun insertDress(dress: Dress)

    suspend fun deletePerson(person: Person)

    suspend fun deleteDress(dress: Dress)

    suspend fun deleteSizeBody(sizeBody: SizeBody)

    suspend fun getPersonByPhone(phone: String) : Person?

}