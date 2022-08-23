package fts.ahmed.school.model.datasources.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fts.ahmed.school.model.models.Student
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Student::class],version = 2, exportSchema = false )
abstract class LocalDatabase :RoomDatabase(){
    // this abstract function returns the DAO
    abstract fun studentsDao() : StudentsDao
}