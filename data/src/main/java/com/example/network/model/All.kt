package com.example.network.model

import com.google.gson.annotations.SerializedName

data class All(
    @SerializedName("info") var info: Info? = Info(),
    @SerializedName("data") var data: Data? = Data()
)