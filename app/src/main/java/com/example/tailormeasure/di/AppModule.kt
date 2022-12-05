package com.example.tailormeasure.di

import android.app.Application
import androidx.room.Room
import com.example.tailormeasure.data.data_resource.PersonDataBase
import com.example.tailormeasure.data.repository.PersonRepositoryImpl
import com.example.tailormeasure.domain.repository.PersonRepository
import com.example.tailormeasure.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDataBase(app: Application): PersonDataBase {
        return Room.databaseBuilder(
            app,
            PersonDataBase::class.java,
            "person.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideRepository(db: PersonDataBase): PersonRepository {
        return PersonRepositoryImpl(db.dao)
    }

    @Singleton
    @Provides
    fun providePersonUseCase(repository: PersonRepository): PersonUseCase {
        return PersonUseCase(
            addPerson = AddPersonUseCase(repository),
            searchPerson = SearchUseCase(repository),
            deletePerson = DeletePersonUseCase(repository),
            getPerson = GetPersonUseCase(repository),
            getPersonWithDress = GetPersonWithDressUseCase(repository),
            addDress = AddDressUseCase(repository)
        )
    }
}