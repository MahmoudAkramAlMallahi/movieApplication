package com.example.listmoves.ui

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listmoves.R
import com.example.listmoves.data.State
import com.example.listmoves.data.model.Movie

@BindingAdapter(value=["app:showWhenLoding"])
fun <T> showWhenLoding(view: View, state: State<T>?) {
    if (state is State.Loading) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:showWhentError"])
fun <T> showWhenError(view: View, state:State<T>?) {
    if (state is State.Error) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value=["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state:State<T>?) {
    if (state is State.Success) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}
@BindingAdapter(value = ["app:setImageUrl"])
fun setImageFromUrl(view:ImageView,url:String?){
//    Glide.with(view).load(url).centerCrop().into(view)
    Glide.with(view)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.ic_launcher_background)
        .into(view)
    Log.i("mah",url+"")
}

@BindingAdapter(value = ["app:setItems"])
fun setRecyclerItems(view:RecyclerView,moveies:List<Movie>?){
    if(moveies !=null){
        (view.adapter as MovieAdapter).setItem(moveies)
    }else{
        (view.adapter as MovieAdapter).setItem(emptyList())
    }
}