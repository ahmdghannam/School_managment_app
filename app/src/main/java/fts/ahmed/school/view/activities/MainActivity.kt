package fts.ahmed.school.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import fts.ahmed.school.R
import fts.ahmed.school.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpButtonsClicks()
    }

    private fun setUpButtonsClicks() {
        binding.btnAddInfo.setOnClickListener{
            goTo(AddInfoActivity::class.java)
        }
        binding.btnSearch.setOnClickListener{
            goTo(SearchActivity::class.java)
        }
    }

    private fun goTo(nextActivity: Class<*>?) {
        val intent = Intent(this,nextActivity)
        startActivity(intent)
    }

}