package com.example.network.model

import com.google.gson.annotations.SerializedName


data class Datasets (
  @SerializedName("all" ) var all : All? = All()
)