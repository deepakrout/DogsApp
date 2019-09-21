package com.iappstogo.dogsapp.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.iappstogo.dogsapp.R
import com.iappstogo.dogsapp.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import java.util.*


//Fragments: List Fragment
class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val dogsListAdapter = DogsListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    //onViewCreated to get the view up and running
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        dogsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dogsListAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.dogs.observe(this, androidx.lifecycle.Observer{ dogs ->
            dogs?.let {
                dogsList.visibility = View.VISIBLE
                dogsListAdapter.updateDogList(dogs)
            }
        })

        viewModel.dogsLoadError.observe(this, androidx.lifecycle.Observer { isError->
            isError?.let {
                listError.visibility = if (it) View.VISIBLE else View.GONE
            }
        })

        viewModel.loading.observe(this, androidx.lifecycle.Observer { isLoading->
            isLoading?.let {
                loadingView.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    listError.visibility = View.GONE
                    dogsList.visibility = View.GONE
                }
            }

        })
    }


}
