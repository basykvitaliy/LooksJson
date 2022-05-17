package com.afffundavbles.loockjson.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.afffundavbles.loockjson.MAIN
import com.afffundavbles.loockjson.R
import com.afffundavbles.loockjson.SaveShared
import com.afffundavbles.loockjson.databinding.FragmentDetailBinding
import com.afffundavbles.loockjson.models.MovieItemModel
import com.afffundavbles.loockjson.screens.main.MainAdapter
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {
    private var mBinding: FragmentDetailBinding?= null
    private val binding get() = mBinding!!
    lateinit var currentMovie: MovieItemModel
    private var isFavorite = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentMovie = arguments?.getSerializable("movie") as MovieItemModel
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val valueBool = SaveShared.getFavorite(MAIN, currentMovie.id.toString())
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        if (isFavorite != valueBool){
            binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        }else{
            binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }

        Glide.with(MAIN)
            .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${currentMovie.poster_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imgDetail)
        binding.tvTitle.text = currentMovie.title
        binding.tvDate.text = currentMovie.release_date
        binding.tvDescription.text = currentMovie.overview

        binding.imgDetailFavorite.setOnClickListener {
            if(isFavorite == valueBool){
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                SaveShared.setFavorite(MAIN, currentMovie.id.toString(), true)
                viewModel.insert(currentMovie){}
                isFavorite = true
            }else{
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                viewModel.delete(currentMovie){}
                SaveShared.setFavorite(MAIN, currentMovie.id.toString(), false)
                isFavorite = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}