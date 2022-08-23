package fts.ahmed.school.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import fts.ahmed.school.view.search.RecyclerViewAdapter
import fts.ahmed.school.databinding.ActivitySearchBinding
import fts.ahmed.school.viewModel.MainViewModel

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySearchBinding
    private lateinit var studentsAdapter: RecyclerViewAdapter
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
        setupLiveData()
        theSearchFunctionality()
    }

    private fun setUpRecyclerView() {
        studentsAdapter = RecyclerViewAdapter()
        binding.rvSearch.adapter = studentsAdapter
    }

    private fun theSearchFunctionality() {
        binding.etSearch.addTextChangedListener {
            viewModel.searchStudent(it.toString().trim())
        }
    }

    private fun setupLiveData() {
        lifecycleScope.launchWhenStarted {
            viewModel.allStudents.observe(this@SearchActivity) {
                studentsAdapter.differ.submitList(it)
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.searchStudents.collect {
                studentsAdapter.differ.submitList(it)
            }
        }
    }
}