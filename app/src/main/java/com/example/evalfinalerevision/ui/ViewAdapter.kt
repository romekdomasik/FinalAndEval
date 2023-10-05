package com.example.evalfinalerevision.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.evalfinalerevision.databinding.CellLayoutBinding
import com.example.evalfinalerevision.model.MovieResponse
import com.example.evalfinalerevision.model.MovieResult

class ViewAdapter(private var results: List<MovieResult>): RecyclerView.Adapter<ViewHolder>() {

    private lateinit var binding: CellLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CellLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(results[position])
    }
}
