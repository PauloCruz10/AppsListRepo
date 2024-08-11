package com.example.network.model

import com.google.gson.annotations.SerializedName

data class Time(

    @SerializedName("seconds") var seconds: Double? = null,
    @SerializedName("human") var human: String? = null

)