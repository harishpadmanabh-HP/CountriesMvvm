package com.harish.countriesmvvm

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries(): Call<List<CountryResponseItem>>



}