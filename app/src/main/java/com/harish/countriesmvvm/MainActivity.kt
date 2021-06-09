package com.harish.countriesmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: CountryViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel =  ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getCountries()
        observe()

    }

    private fun observe() {
        viewModel.apply {
            data.observe(this@MainActivity, Observer {
                val ccountires = it
                ccountires?.forEach {
                    Log.e("Country name","${it.name}..")
                }
            })


            errorData.observe(this@MainActivity, Observer {
                Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
            })

            apiStatusData.observe(this@MainActivity, Observer {
                when(it)
                {
                    ApiStatus.LODING->{
                        //show progress
                    }
                    ApiStatus.SUCCESS->{
                       // hide progress
                    }
                    ApiStatus.ERROR->{
                        //  handle error
                    }
                }
            })

        }
    }
}