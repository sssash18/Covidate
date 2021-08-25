package com.suyash.covidate.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.airbnb.lottie.LottieAnimationView
import com.suyash.covidate.R

    class ScreenSlideAdapter(val context: Context): PagerAdapter(){
    private val tipsarray = arrayOf(R.string.tip1,R.string.tip2,R.string.tip3,R.string.tip4,R.string.tip5)
    private val animarr = arrayOf(R.raw.hand,R.raw.social,R.raw.home,R.raw.sick,R.raw.mask)

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return tipsarray.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.fragment_slide,container,false)
        val textView  = view.findViewById<TextView>(R.id.text)
        val animationView = view.findViewById<LottieAnimationView>(R.id.lottieAnimationView)
        textView.setText(tipsarray[position])
        animationView.setAnimation(animarr[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}