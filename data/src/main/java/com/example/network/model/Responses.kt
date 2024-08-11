package com.example.network.model

import com.google.gson.annotations.SerializedName


data class Responses (
  @SerializedName("listApps" ) var listApps : ListApps? = ListApps()
)