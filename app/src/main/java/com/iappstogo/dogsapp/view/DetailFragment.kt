package com.iappstogo.dogsapp.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

import com.iappstogo.dogsapp.R
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {

    private var dogUuid = 0
    private var humanUuid = "RIN-000-56432-0908IKM"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    //Take user back to list - 09/26/2019
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Retrieving arguments - and processing it
        arguments?.let {
            //Initializing to the local variable.
            dogUuid = DetailFragmentArgs.fromBundle(it).dogUuid

        }

        //TODO: Logic to navigate to list


    }

}
