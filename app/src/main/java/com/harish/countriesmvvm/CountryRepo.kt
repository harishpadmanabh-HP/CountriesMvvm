package com.harish.countriesmvvm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryRepo(val context: Context) {

    val api = ApiManger(context).api

    var apiStatusData = MutableLiveData<ApiStatus>()



    fun getCountries(onApiResult:(status:Boolean,error:String?,result:List<CountryResponseItem>?)->Unit){

        apiStatusData.value = ApiStatus.LODING

        api.getCountries().enqueue(object :Callback<List<CountryResponseItem>>{
            override fun onFailure(call: Call<List<CountryResponseItem>>, t: Throwable) {
                onApiResult(false,"${t.localizedMessage}",null)
                apiStatusData.value = ApiStatus.ERROR

            }

            override fun onResponse(
                call: Call<List<CountryResponseItem>>,
                response: Response<List<CountryResponseItem>>
            ) {
                if(response.isSuccessful){
                    apiStatusData.value = ApiStatus.SUCCESS
                    onApiResult(true,null,response.body())

                }
                else
                    onApiResult(false,"Some thing went wrong",null)
            }
        })
    }

}

enum class ApiStatus {
    LODING,
    SUCCESS,
    ERROR
}