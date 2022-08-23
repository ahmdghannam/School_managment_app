package fts.ahmed.school.model.datasources.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import fts.ahmed.school.model.models.Student
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentsDao {

    @Query("select * from students_table")
    fun getAllStudents(): Flow<List<Student>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: Student)

    @Query("select * from students_table where name like '%'||:name||'%' ")
    fun searchStudent(name: String): Flow<List<Student>>

    @Delete
    suspend fun deleteStudent(student: Student)
}