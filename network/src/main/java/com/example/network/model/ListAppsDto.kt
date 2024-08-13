package com.example.network.model

import com.google.gson.annotations.SerializedName

data class ListAppsDto(
    @SerializedName("info") var info: InfoDto? = InfoDto(),
    @SerializedName("datasets") var datasets: DatasetsDto? = DatasetsDto()
)