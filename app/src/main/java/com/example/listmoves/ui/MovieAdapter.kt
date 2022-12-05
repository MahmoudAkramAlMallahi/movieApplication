package com.example.listmoves.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.listmoves.R
import com.example.listmoves.data.model.Movie
import com.example.listmoves.databinding.ItemListMoveBinding

class MovieAdapter(private var items: List<Movie>,private var listener:MovieInteractionListener):RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val item=LayoutInflater.from(parent.context).inflate(R.layout.item_list_move,parent,false)
        return MovieHolder(item)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie=items[position]
        holder.binding.item=movie
        holder.binding.listener=listener
    }

    override fun getItemCount()=items.size

    fun setItem(items:List<Movie>){
        this.items=items
    }

    class MovieHolder(item: View):ViewHolder(item){
        val binding=ItemListMoveBinding.bind(item)
    }
}

interface MovieInteractionListener{
    fun onClick(movie: Movie)
}