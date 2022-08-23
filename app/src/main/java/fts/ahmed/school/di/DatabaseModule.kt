package fts.ahmed.school.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fts.ahmed.school.model.datasources.roomdatabase.LocalDatabase
import fts.ahmed.school.model.datasources.roomdatabase.StudentsDao
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context):LocalDatabase{
        return Room.databaseBuilder(
            context.applicationContext,
            LocalDatabase::class.java,
            "students_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides

    fun provideTheDao(database: LocalDatabase):StudentsDao{
        return database.studentsDao()
    }

}