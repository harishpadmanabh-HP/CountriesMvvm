package com.harish.countriesmvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class CountryViewModel(val app: Application): AndroidViewModel(app) {

    val repo = CountryRepo(app)

    var data = MutableLiveData<List<CountryResponseItem>>()
    var errorData = MutableLiveData<String>()

    var apiStatusData = repo.apiStatusData


    fun getCountries()=repo.getCountries(onApiResult = {
        status, error, result ->
        when(status)
        {
            true->{
                data.value = result
            }
            false->{
                errorData.value = error
            }
        }


    })




}