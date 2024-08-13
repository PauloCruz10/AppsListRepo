package com.example.network.model

import com.google.gson.annotations.SerializedName

data class AllDto(
    @SerializedName("info") var info: InfoDto? = InfoDto(),
    @SerializedName("data") var data: DataDto? = DataDto()
)