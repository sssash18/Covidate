package com.suyash.covidate.ui

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.suyash.covidate.R
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.AdSize

class InfoActivity: FragmentActivity() {

    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_info)
        viewPager = findViewById(R.id.pager)

        val adapter = ScreenSlideAdapter(this)
        viewPager.adapter = adapter
//        val adview = com.facebook.ads.AdView(this,"593336774616651_593355034614825",
//            AdSize.BANNER_HEIGHT_50)
//        val adContainer = findViewById<LinearLayout>(R.id.banner_container)
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
    }


}