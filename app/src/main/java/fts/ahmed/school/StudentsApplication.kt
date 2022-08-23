package fts.ahmed.school

import android.app.Application
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import fts.ahmed.school.model.datasources.Repository
import fts.ahmed.school.model.datasources.roomdatabase.LocalDatabase

@HiltAndroidApp
class StudentsApplication : Application()