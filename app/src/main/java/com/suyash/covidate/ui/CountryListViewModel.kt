package com.suyash.covidate.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.suyash.covidate.network.CountryAPI
import com.suyash.covidate.network.CountryAPIstatus
import com.suyash.covidate.network.CovidDataList
import com.suyash.covidate.network.CovidLocal
import kotlinx.coroutines.*
import java.lang.Exception

class CountryListViewModel(app:Application):AndroidViewModel(app) {
    val viewModelJob = Job()
    val uiscope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val _response = MutableLiveData<CovidDataList>()
    val result : LiveData<CovidDataList>
           get() = _response

    private val _navigateToList = MutableLiveData<CovidDataList>()
    val navigateToList : LiveData<CovidDataList>
        get() = _navigateToList

    private val _navigateDetail  = MutableLiveData<CovidLocal>()
        val navigateDetail : LiveData<CovidLocal>
            get() = _navigateDetail

    private val _status = MutableLiveData<CountryAPIstatus>()
    val status:LiveData<CountryAPIstatus>
        get() = _status

    init {
        _status.value =  CountryAPIstatus.LOADING
        getText()
    }

    fun getText(){
        uiscope.launch {
            _status.value = CountryAPIstatus.LOADING
            try{

                _response.value = CountryAPI.retrofitservice.getProperties().await()
                _status.value = CountryAPIstatus.SUCCESS
            }catch (e:Exception){
                _status.value = CountryAPIstatus.FAILURE
                Log.e("Error",e.toString())
            }
        }

    }

    fun displayList(){
        _navigateToList.value = _response.value

    }

    fun displayListComplete(){
        _navigateToList.value = null
    }

    fun displayDetail(covid:CovidLocal){
        _navigateDetail.value = covid
    }

    fun displayDetailComplete(){
        _navigateDetail.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
