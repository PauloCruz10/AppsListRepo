package com.example.network.model

import com.google.gson.annotations.SerializedName

data class InfoDto(
    @SerializedName("status") var status: String? = null,
    @SerializedName("time") var time: TimeDto? = TimeDto()
)