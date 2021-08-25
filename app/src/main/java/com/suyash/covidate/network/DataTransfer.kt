package com.suyash.covidate.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CovidDataList(
    val Global:CovidGlobal,
    val Countries:List<CovidLocal>,
    val Date:String
):Parcelable

@Parcelize
data class CovidGlobal(
    val NewConfirmed:Int,
    val TotalConfirmed:Int,
    val NewDeaths:Int,
    val TotalDeaths:Int,
    val NewRecovered:Int,
    val TotalRecovered:Int
):Parcelable


@Parcelize
data class CovidLocal(
    val Country:String,
    val CountryCode:String,
    val Slug:String,
    val NewConfirmed:Int,
    val TotalConfirmed:Int,
    val NewDeaths:Int,
    val TotalDeaths:Int,
    val NewRecovered:Int,
    val TotalRecovered:Int,
    val Date:String
):Parcelable

enum class CountryAPIstatus{
    LOADING,
    SUCCESS,
    FAILURE
}
