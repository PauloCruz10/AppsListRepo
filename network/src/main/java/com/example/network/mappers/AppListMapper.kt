package com.example.network.mappers

import com.example.network.model.AllAppsInfoDto
import com.example.network.model.AllDto
import com.example.network.model.DataDto
import com.example.network.model.DatasetsDto
import com.example.network.model.InfoDto
import com.example.network.model.ListAppsDto
import com.example.network.model.ListDto
import com.example.network.model.ResponsesDto
import com.example.network.model.TimeDto
import com.example.shareddata.model.appsList.All
import com.example.shareddata.model.appsList.AllAppsInfo
import com.example.shareddata.model.appsList.AppInfo
import com.example.shareddata.model.appsList.Data
import com.example.shareddata.model.appsList.Datasets
import com.example.shareddata.model.appsList.Info
import com.example.shareddata.model.appsList.ListApps
import com.example.shareddata.model.appsList.Responses
import com.example.shareddata.model.appsList.Time

fun AllDto.mapToLib(): All = All(info?.mapToLib(), data?.mapToLib())

fun InfoDto.mapToLib() = Info(status, time?.mapToLib())

fun TimeDto.mapToLib() = Time(seconds, human)
fun DataDto.mapToLib() = Data(total, offset, limit, next, hidden, list.mapToLib())
fun ListDto.mapToLib() = AppInfo(id, name, appPackage, storeId, storeName, vername, vercode, md5sum, apkTags, size, downloads, pdownloads, added, modified, updated, rating, icon, graphic, uptype)
fun List<ListDto>.mapToLib()  = this.map { it.mapToLib() }
fun ListAppsDto.mapToLib() = ListApps(info?.mapToLib(), datasets?.mapToLib())
fun DatasetsDto.mapToLib() = Datasets(all?.mapToLib())
fun ResponsesDto.mapToLib() = Responses(listApps?.mapToLib())
fun AllAppsInfoDto.mapToLib() = AllAppsInfo(status, responses?.mapToLib())
