package com.kanyideveloper.onboardingscreensdemo


import com.google.gson.annotations.SerializedName

class Beers : ArrayList<Beers.BeersItem>() {
    data class BeersItem(
        @SerializedName("description")
        val description: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("image_url")
        val imageUrl: String?,
        @SerializedName("name")
        val name: String?
    )
}