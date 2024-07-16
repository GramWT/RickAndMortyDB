package com.example.rickandmortydb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.rickandmortydb.databinding.ActivityCharacterDetailsBinding
import com.example.rickandmortydb.utils.ViewUtils.gone
import com.example.rickandmortydb.utils.ViewUtils.visible
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
        fun createIntent(context: Context, id: Int): Intent {
            return Intent(context, CharacterDetailsActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent.getIntExtra(EXTRA_ID, 0)?.also {
            viewModel.getCharacterById(it)
        }

        binding.backButton.setOnClickListener {
            finish()
        }

        attachObserver()
    }

    private fun attachObserver() {
        viewModel.character.observe(this) {
            Glide.with(this)
                .load(it?.image)
                .into(binding.characterImageView)

            binding.nameTextView.text = it?.name
            it?.species?.also {
                binding.speciesTextView.text = "Species : " + it
                if (it.isEmpty()){
                    binding.speciesTextView.gone()
                }else{
                    binding.speciesTextView.visible()
                }
            }
            it?.gender?.also {
                binding.genderTextView.text = "Gender : " + it
                if (it.isEmpty()){
                    binding.genderTextView.gone()
                }else{
                    binding.genderTextView.visible()
                }
            }
            it?.type?.also {
                binding.typeTextView.text = "Type : " + it
                if (it.isEmpty()){
                    binding.typeTextView.gone()
                }else{
                    binding.typeTextView.visible()
                }
            }
            it?.origin?.name?.also {
                binding.originalTextView.text = "Original : " + it
                if (it.isEmpty()){
                    binding.originalTextView.gone()
                }else{
                    binding.originalTextView.visible()
                }
            }
            it?.location?.name?.also {
                binding.locationTextView.text = "Location : " + it
                if (it.isEmpty()){
                    binding.locationTextView.gone()
                }else{
                    binding.locationTextView.visible()
                }
            }
        }
    }
}