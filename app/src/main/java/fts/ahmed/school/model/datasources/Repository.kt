package fts.ahmed.school.model.datasources

import androidx.annotation.WorkerThread
import fts.ahmed.school.model.datasources.roomdatabase.StudentsDao
import fts.ahmed.school.model.models.Student
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class Repository @Inject constructor(private val mDao: StudentsDao) {


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(student: Student) {
        mDao.insert(student)
    }

    fun getAllStudents(): Flow<List<Student>> {
        return mDao.getAllStudents()
    }

    suspend fun searchStudent(name: String): Flow<List<Student>> {
        return mDao.searchStudent(name)
    }

    suspend fun deleteStudent(student: Student) {
        mDao.deleteStudent(student)
    }
}