package com.example.tailormeasure.data.repository

import com.example.tailormeasure.data.data_resource.PersonDao
import com.example.tailormeasure.domain.model.Dress
import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.domain.model.SizeBody
import com.example.tailormeasure.domain.relation.PersonAndSizeBody
import com.example.tailormeasure.domain.relation.PersonWithDress
import com.example.tailormeasure.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow

class PersonRepositoryImpl(
    private val dao : PersonDao
) : PersonRepository {
    override fun getPersons(): Flow<List<Person>> {
       return dao.getPersons()
    }

    override fun getDressesByPhone(phone: String): Flow<List<PersonWithDress>> {
        return dao.getPersonWithDress(phone)
    }

    override fun searchQuery(query: String): Flow<List<Person>> {
        return dao.searchPerson(query)
    }

    override suspend fun getSizeBody(phone: String): PersonAndSizeBody? {
        return dao.getSizeAndPerson(phone)
    }

    override suspend fun insertPerson(person: Person) {
         dao.insertPerson(person)
    }

    override suspend fun insertSizeBody(sizeBody: SizeBody) {
        dao.insertSizeBody(sizeBody)
    }

    override suspend fun insertDress(dress: Dress) {
        dao.insertDress(dress)
    }

    override suspend fun deletePerson(person: Person) {
        dao.deletePerson(person)
    }

    override suspend fun deleteDress(dress: Dress) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSizeBody(sizeBody: SizeBody) {
        TODO("Not yet implemented")
    }

    override suspend fun getPersonByPhone(phone: String): Person? {
        return dao.getPersonByPhone(phone)
    }
}