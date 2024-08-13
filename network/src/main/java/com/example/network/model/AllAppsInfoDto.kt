package com.example.network.model

import com.google.gson.annotations.SerializedName

data class AllAppsInfoDto(
    @SerializedName("status") var status: String? = null,
    @SerializedName("responses") var responses: ResponsesDto? = ResponsesDto()

)