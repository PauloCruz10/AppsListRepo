package com.example.network.model

import com.google.gson.annotations.SerializedName

data class TimeDto(
    @SerializedName("seconds") var seconds: Double? = null,
    @SerializedName("human") var human: String? = null
)