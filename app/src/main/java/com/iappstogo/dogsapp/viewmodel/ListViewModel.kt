package com.iappstogo.dogsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iappstogo.dogsapp.model.DogBreed

class ListViewModel(): ViewModel() {
    val dogs = MutableLiveData<List<DogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    //Refresh Method of view model
    fun refresh() {
        val dog1 = DogBreed("1","Corgi", "15 years", "breedGroup","BreFor", "Temerament","")
        val dog2 = DogBreed("2","Labrador", "15 years", "breedGroup","BreFor", "Temerament","")
        val dog3 = DogBreed("3","Rotwailer", "20 years", "breedGroup","BreFor", "Temerament","")
        val dogList: ArrayList<DogBreed> = arrayListOf(dog1, dog2, dog3)

        dogs.value = dogList
        dogsLoadError.value = false
        loading.value = false

    }
}