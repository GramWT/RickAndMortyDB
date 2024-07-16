package com.example.rickandmortydb

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortydb.adapter.RickAndMortyAdapter
import com.example.rickandmortydb.utils.ViewUtils.gone
import com.example.rickandmortydb.utils.ViewUtils.visible
import com.example.rickandmortydb.databinding.ActivityMainBinding
import com.example.rickandmortydb.model.ResultsItem
import com.example.rickandmortydb.viewmodel.RickAndMortyViewModel

class MainActivity : AppCompatActivity() {

    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: RickAndMortyViewModel by viewModels {
        RickAndMortyViewModelFactory()
    }

    private var rickAndMortyListAdapter: RickAndMortyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        rickAndMortyListAdapter = RickAndMortyAdapter()

        binding.recyclerView.apply {
            adapter = rickAndMortyListAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

        binding.backButton.setOnClickListener {
            if (viewModel.page >1){
                viewModel.page -=1
                viewModel.getCharacter()
            }
        }

        binding.forwardButton.setOnClickListener {
            if (viewModel.page < viewModel.maxPage){
                viewModel.page +=1
                viewModel.getCharacter()
            }
        }

        viewModel.getCharacter()

        attachObserver()
    }

    private fun setUI(){
        if (viewModel.page == 1){
            binding.backButton.gone()
            binding.forwardButton.visible()
        }else if (viewModel.page == viewModel.maxPage){
            binding.backButton.visible()
            binding.forwardButton.gone()
        }else{
            binding.backButton.visible()
            binding.forwardButton.visible()
        }
        binding.pageTextView.text = "${viewModel.page}/${viewModel.maxPage}"
        binding.recyclerView.scrollToPosition(0)
    }

    private fun attachObserver() {
        viewModel.allCharacter.observe(this){
             it?.info?.pages?.also {
                 viewModel.maxPage =  it
            }
            it?.results?.also {
                rickAndMortyListAdapter?.setData(it as ArrayList<ResultsItem?>)
            }
            setUI()
        }
    }
}