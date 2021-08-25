package com.suyash.covidate.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.amazon.device.ads.AdLayout
import com.suyash.covidate.R
import com.suyash.covidate.databinding.FragmentDetailBinding
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.AdSize
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_info.*


/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailBinding.inflate(inflater,container,false)
        val args = DetailFragmentArgs.fromBundle(requireArguments())
        binding.headCountry.text = args.countrydetail.Country
        binding.confirmno.text = args.countrydetail.TotalConfirmed.toString()
        binding.deathno.text = args.countrydetail.TotalDeaths.toString()
        binding.recovno.text = args.countrydetail.TotalRecovered.toString()
        binding.flagView.setCountryCode(args.countrydetail.CountryCode)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
//        val adview = com.facebook.ads.AdView(this.context,"593336774616651_593355034614825",
//            AdSize.BANNER_HEIGHT_50)
//        val adContainer = requireView().findViewById<LinearLayout>(R.id.banner_container)
//        adContainer.addView(adview)
//        adview.loadAd()
//        adview.setAdListener(object : com.facebook.ads.AdListener{
//            override fun onAdClicked(p0: Ad?) {
//                Log.i("Displayed", "CLicked")
//            }
//
//            override fun onError(p0: Ad?, p1: AdError?) {
//                adview.loadAd()
//            }
//
//            override fun onAdLoaded(p0: Ad?) {
//                Log.i("Displayed", "Loaded")
//            }
//
//            override fun onLoggingImpression(p0: Ad?) {
//                Log.i("Displayed", "Displayed")
//            }
//        })

        this.adview.loadAd()

    }

}
