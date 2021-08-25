package com.suyash.covidate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.amazon.device.ads.AdRegistration
import com.facebook.ads.*
import com.facebook.ads.InterstitialAd
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : AppCompatActivity() {


    private lateinit var mInterstitialAd:com.amazon.device.ads.InterstitialAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AdRegistration.setAppKey("48bfbacf7c434c29a85fec105ff284ec")
        AdRegistration.enableLogging(true)
        this.mInterstitialAd = com.amazon.device.ads.InterstitialAd(this)
        this.mInterstitialAd.loadAd()
        this.mInterstitialAd.showAd()

//        AudienceNetworkAds.initialize(this)
//        mInterstitialAd = InterstitialAd(this,"593336774616651_593338677949794")
//        mInterstitialAd.loadAd()
//        mInterstitialAd.setAdListener( object : InterstitialAdListener{
//            override fun onError(p0: Ad?, p1: AdError?) {
//                mInterstitialAd.loadAd()
//            }
//
//            override fun onInterstitialDisplayed(p0: Ad?) {
//                Log.i("Displayed", "Displayed")
//            }
//
//            override fun onAdClicked(p0: Ad?) {
//                Log.i("Displayed", "Clicked")
//            }
//
//            override fun onInterstitialDismissed(p0: Ad?) {
//
//                Log.i("Displayed", "Dismissed")
//            }
//
//            override fun onAdLoaded(p0: Ad?) {
//                Log.i("Displayed", "Loaded")
//            }
//
//            override fun onLoggingImpression(p0: Ad?) {
//                Log.i("Displayed", "Logging")
//            }
//
//        })
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("Notification", "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                // Log and toast
                val msg = token.toString()
                Log.d("Notification", msg)
            })
    }


}

