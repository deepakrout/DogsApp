package com.iappstogo.dogsapp.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

import com.iappstogo.dogsapp.R
import kotlinx.android.synthetic.main.fragment_list.*
import java.util.*


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set Nav direction when the button i clicked
        buttonDetails.setOnClickListener {
            val action :NavDirections = ListFragmentDirections.actionListFragmentToActionDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }


}
