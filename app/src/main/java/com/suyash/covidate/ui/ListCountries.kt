package com.suyash.covidate.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.suyash.covidate.databinding.FragmentListBinding
import com.suyash.covidate.databinding.TextViewItemBinding
import com.suyash.covidate.network.CovidLocal

/**
 * A simple [Fragment] subclass.
 */
class ListCountries : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBinding.inflate(inflater)
        val datalist = ListCountriesArgs.fromBundle(
            requireArguments()
        ).countrylist.Countries
        val adapter = CountryListAdapter(CountryListAdapter.OnClickListener{item: CovidLocal ->  this.findNavController().navigate(ListCountriesDirections.actionListCountriesToDetailFragment(item))})
        adapter.data = datalist
        binding.listcountry.adapter = adapter
        return binding.root
    }

}
