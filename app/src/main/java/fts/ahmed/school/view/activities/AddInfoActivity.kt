package fts.ahmed.school.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import fts.ahmed.school.R
import fts.ahmed.school.databinding.ActivityAddInfoBinding
import fts.ahmed.school.databinding.ActivitySearchBinding
import fts.ahmed.school.model.models.Student
import fts.ahmed.school.viewModel.MainViewModel

@AndroidEntryPoint
class AddInfoActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityAddInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_info)
        initViewModel()
        binding.btnAddToDatabase.setOnClickListener {
            viewModel.addToDatabase()
        }
    }

    private fun initViewModel() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.toastEvent.observe(this) { // on the change of toast event live data it will execute this code
            Toast.makeText(this@AddInfoActivity, it, Toast.LENGTH_SHORT).show()
        }
    }

}