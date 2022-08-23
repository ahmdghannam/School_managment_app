package fts.ahmed.school.model.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "students_table")
 class Student  {
    val name: String
    val dateOfBirth: String
    @PrimaryKey
    val id: String
    val major: String

    constructor( name: String, dateOfBirth: String, id: String, major: String) {
        this.name = name
        this.dateOfBirth = dateOfBirth
        this.id = id
        this.major = major
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}