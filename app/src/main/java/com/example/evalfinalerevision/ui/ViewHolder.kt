package com.example.evalfinalerevision.ui

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.evalfinalerevision.R
import com.example.evalfinalerevision.databinding.CellLayoutBinding
import com.example.evalfinalerevision.model.MovieResult
import com.squareup.picasso.Picasso

class ViewHolder(private var viewBinding: CellLayoutBinding): RecyclerView.ViewHolder(viewBinding.root) {
    fun bind(result: MovieResult){
        val url = result.poster_path
        viewBinding.movieName.text = result.title
        viewBinding.movieDate.text = result.release_date
        viewBinding.movieScore.text = result.vote_average.toString()
        setupImage(url, viewBinding.movieImg)

    }

    private fun setupImage(url: String?, imageView: ImageView) {
        if (!url.isNullOrEmpty()) {
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500$url") // Utilisez l'URL complet pour l'image
                .fit()
                .centerCrop()
                .into(imageView)
        }
    }
}
