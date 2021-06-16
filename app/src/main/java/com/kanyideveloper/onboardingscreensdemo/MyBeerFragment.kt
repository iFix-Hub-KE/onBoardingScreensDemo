package com.kanyideveloper.onboardingscreensdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.kanyideveloper.onboardingscreensdemo.databinding.FragmentMyBeerBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MyBeerFragment"
class MyBeerFragment : Fragment() {
   private lateinit var binding: FragmentMyBeerBinding
   private val adapter by lazy { BeersAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentMyBeerBinding.inflate(inflater,container,false)
        val view = binding.root



        BeersApi.apiService.getBeers().enqueue(object: Callback<Beers>{
            override fun onResponse(call: Call<Beers>, response: Response<Beers>) {
                Log.d(TAG, "onResponse: ${response.body()}")
                val myList = response.body()
                adapter.submitList(myList)
                binding.myFeedRecyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<Beers>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.localizedMessage}")
            }

        })

        return view
    }
}