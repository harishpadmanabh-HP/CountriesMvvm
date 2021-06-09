package com.harish.countriesmvvm

import com.google.gson.annotations.SerializedName

    data class CountryResponseItem(

        @SerializedName("flag")
        val flag: String,

        @SerializedName("name")
        val name: String

    ) {

    

    }
