package com.suyash.covidate.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.suyash.covidate.databinding.FragmentCountryListBinding
import com.suyash.covidate.network.CountryAPIstatus
import com.suyash.covidate.network.CovidDataList
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.InterstitialAdListener

/**
 * A simple [Fragment] subclass.
 */
class CountryList : Fragment() {

    private lateinit var mInterstitialAd:com.facebook.ads.InterstitialAd

    private val viewModel : CountryListViewModel by lazy {
        ViewModelProviders.of(this).get(CountryListViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        mInterstitialAd = com.facebook.ads.InterstitialAd(this.activity,"593336774616651_593338677949794")
//        mInterstitialAd.loadAd()
//        mInterstitialAd.setAdListener( object : InterstitialAdListener {
//            override fun onError(p0: Ad?, p1: AdError?) {
//                mInterstitialAd.loadAd()
//            }
//
//            override fun onInterstitialDisplayed(p0: Ad?) {
//                Log.i("Displayed", "Displayed")
//            }
//
//            override fun onAdClicked(p0: Ad?) {
//                Log.i("Displayed", "Displayed")
//            }
//
//            override fun onInterstitialDismissed(p0: Ad?) {
//                Log.i("Displayed", "Displayed")
//            }
//
//            override fun onAdLoaded(p0: Ad?) {
//                Log.i("Displayed", "Displayed")
//            }
//
//            override fun onLoggingImpression(p0: Ad?) {
//                Log.i("Displayed", "Displayed")
//            }
//
//        })

        val binding = FragmentCountryListBinding.inflate(inflater)
        binding.arrow.setOnClickListener { navigateToList() }
        binding.info.setOnClickListener { navigateToInfo() }
        binding.retry.setOnClickListener {viewModel.getText()
            binding.retry.visibility = View.GONE
            binding.loading.visibility = View.VISIBLE }
        val TextObserver = Observer<CovidDataList>{
            binding.confirmno.text = it.Global.TotalConfirmed.toString()
            binding.deathno.text = it.Global.TotalDeaths.toString()
            binding.recovno.text = it.Global.TotalRecovered.toString()
        }
        viewModel.result.observe(viewLifecycleOwner,TextObserver)
        val statusObserver = Observer<CountryAPIstatus> {
            when(it){
                CountryAPIstatus.SUCCESS -> {binding.loading.visibility = View.GONE
                    binding.label.visibility = View.VISIBLE
                    binding.answer.visibility = View.VISIBLE
                    binding.retry.visibility = View.GONE
                }
                CountryAPIstatus.FAILURE -> {
                    binding.label.visibility = View.GONE
                    binding.loading.visibility = View.GONE
                    binding.answer.visibility = View.GONE
                    binding.retry.visibility = View.VISIBLE
                }
                CountryAPIstatus.LOADING -> {
                    binding.label.visibility = View.GONE
                    binding.answer.visibility = View.GONE
                }
            }
        }
        viewModel.status.observe(viewLifecycleOwner,statusObserver)
        val navigateObserver = Observer<CovidDataList> {
            if(it!=null){
                this.findNavController().navigate(CountryListDirections.actionCountryListToListCountries(it))
                viewModel.displayListComplete()
            }
        }
        viewModel.navigateToList.observe(viewLifecycleOwner,navigateObserver)
        return binding.root
    }
    var count = 0
    private fun navigateToList(){
        viewModel.displayList()
//        if(count == 1) {
//
//        }else{
//            if(mInterstitialAd.isAdLoaded){
//                mInterstitialAd.show()
//                count=1
//            }
//
//        }
    }

    private fun navigateToInfo(){
        val intent = Intent(this.context,InfoActivity::class.java)
        startActivity(intent)
    }

}


