package com.example.network.model

import com.google.gson.annotations.SerializedName

data class AllAppsInfo(
    @SerializedName("status") var status: String? = null,
    @SerializedName("responses") var responses: Responses? = Responses()

)