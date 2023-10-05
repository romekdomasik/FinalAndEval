package com.example.evalfinalerevision.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.evalfinalerevision.databinding.CellLayoutBinding
import com.example.evalfinalerevision.model.MovieResponse
import com.example.evalfinalerevision.model.MovieResult

class ViewHolder(private var viewBinding: CellLayoutBinding): RecyclerView.ViewHolder(viewBinding.root) {
    fun bind(result: MovieResult){
        viewBinding.movieName.text = result.title
        viewBinding.movieDate.text = result.release_date
        viewBinding.movieScore.text = result.voteAverage.toString()
    }
}
