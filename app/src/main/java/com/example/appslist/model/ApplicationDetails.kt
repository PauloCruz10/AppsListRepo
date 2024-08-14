package com.example.appslist.model

import com.example.appslist.presentation.ui.detailscreen.AppDetailItem

data class ApplicationDetails(
    val name: String,
    val image: String,
    val details: List<AppDetailItem>,
)