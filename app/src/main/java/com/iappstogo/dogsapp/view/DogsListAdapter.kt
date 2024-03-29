package com.iappstogo.dogsapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iappstogo.dogsapp.R
import com.iappstogo.dogsapp.model.DogBreed
import kotlinx.android.synthetic.main.item_dog.view.*

//Recycle view adapter
class DogsListAdapter(val dogsList: ArrayList<DogBreed>) : RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {

    fun updateDogList(newDogsList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    //Get item counts - 09/25/2019
    //TODO: complete the recycle view implementation
    override fun getItemCount() = dogsList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        //Bind the view holder

        holder.view.name.text = dogsList[position].dogBreed
        holder.view.lifeSpan.text = dogsList[position].lifeSpan

    }

    class DogViewHolder(var view: View) : RecyclerView.ViewHolder(view)

}