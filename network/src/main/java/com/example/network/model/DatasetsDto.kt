package com.example.network.model

import com.google.gson.annotations.SerializedName


data class DatasetsDto (
  @SerializedName("all" ) var all : AllDto? = AllDto()
)