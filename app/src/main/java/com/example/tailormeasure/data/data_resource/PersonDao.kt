package com.example.tailormeasure.data.data_resource

import androidx.room.*
import com.example.tailormeasure.domain.model.Dress
import com.example.tailormeasure.domain.model.Person
import com.example.tailormeasure.domain.model.SizeBody
import com.example.tailormeasure.domain.relation.PersonAndSizeBody
import com.example.tailormeasure.domain.relation.PersonWithDress
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: Person)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSizeBody(sizeBody: SizeBody)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDress(dress: Dress)

    @Delete
    suspend fun deletePerson(person: Person)

    @Update
    suspend fun updatePerson(person: Person)

    @Query("SELECT * FROM Person")
     fun getPersons() : Flow<List<Person>>

    @Transaction
    @Query("SELECT * FROM person WHERE phone = :phone ")
     suspend fun getSizeAndPerson(phone : String) : PersonAndSizeBody

    @Transaction
    @Query("SELECT * FROM Person WHERE phone = :phone")
     fun getPersonWithDress(phone : String) : Flow<List<PersonWithDress>>

    @Query(     """
            SELECT * 
            FROM person
            WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR
                UPPER(:query) == phone
        """)
    fun searchPerson(query : String) :Flow<List<Person>>

    @Query("SELECT * FROM person WHERE phone = :phone")
    suspend fun getPersonByPhone(phone :String) : Person?

}