package com.example.rickandmortydb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmortydb.databinding.ActivityCharacterDetailsBinding
import com.example.rickandmortydb.viewmodel.RickAndMortyViewModel

class CharacterDetailsActivity : BaseActivity() {

    private val binding: ActivityCharacterDetailsBinding by lazy {
        ActivityCharacterDetailsBinding.inflate(layoutInflater)
    }

    private val viewModel: RickAndMortyViewModel by viewModels {
        RickAndMortyViewModelFactory()
    }

    companion object {
        private const val EXTRA_ID = "id"
        fun createIntent(context: Context,id:Int): Intent {
            return Intent(context, CharacterDetailsActivity::class.java).apply {
                putExtra(EXTRA_ID,id)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent.getIntExtra(EXTRA_ID,0)?.also {
            viewModel.getCharacterById(it)
        }

        attachObserver()
    }

    private fun attachObserver() {
        viewModel.character.observe(this){
            Toast.makeText(this,"${it?.name}",Toast.LENGTH_SHORT).show()
        }
    }
}