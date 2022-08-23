package fts.ahmed.school.viewModel

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import fts.ahmed.school.model.datasources.Repository
import fts.ahmed.school.model.models.Student
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    var name = String()
    var dob = String()
    var id = String()
    var major = String()

    val toastEvent = MutableLiveData<String>()

    val allStudents: LiveData<List<Student>> = repository.getAllStudents().asLiveData()

    //    val allStudents= listOf<Student>(Student("Ahmed","9-9","5614","cse"))
    private val _searchStudents = MutableStateFlow<List<Student>>(emptyList())
    val searchStudents: StateFlow<List<Student>> = _searchStudents
    fun searchStudent(name: String) {
        viewModelScope.launch {
            repository.searchStudent(name).collect {
                _searchStudents.emit(it)
            }
        }
    }

    // coroutines are added in the view model level
    fun insert(student: Student) {
        viewModelScope.launch {
            repository.insert(student)
        }
    }

    fun deleteStudent(student: Student) {
        viewModelScope.launch {
            repository.deleteStudent(student)
        }
    }

    fun addToDatabase() {
        if (name.isEmpty() || dob.isEmpty() || id.isEmpty() || major.isEmpty())
            toastEvent.value = "please fill all the fields"
        else {
            insert(Student(name, dob, id, major))
            toastEvent.value = "added to the database"
        }
    }

    fun setTheName(name: CharSequence) {
        this.name = name.toString()
    }

    fun setTheDob(dob: CharSequence) {
        this.dob = dob.toString()
    }

    fun setTheid(id: CharSequence) {
        this.id = id.toString()
    }

    fun setTheMajor(major: CharSequence) {
        this.major = major.toString()
    }
}

