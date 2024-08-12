package com.example.network.model

import com.google.gson.annotations.SerializedName


data class ResponsesDto (
  @SerializedName("listApps" ) var listApps : ListAppsDto? = ListAppsDto()
)