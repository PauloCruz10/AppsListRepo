/*
 * Copyright (c) 2021 WIT Software. All rights reserved.
 *
 * WIT Software Confidential and Proprietary information. It is strictly forbidden for 3rd parties to modify, decompile,
 * disassemble, defeat, disable or circumvent any protection mechanism; to sell, license, lease, rent, redistribute or
 * make accessible to any third party, whether for profit or without charge.
 */

package com.example.appslist.plarform

import android.util.Log
import com.example.shareddata.logger.Logger

private const val LOG_SEPARATOR = " - "

class AppLogger : Logger {

    override fun v(tag: String, method: String, message: String) {
        val finalMessage = getFinalMessage(method, message)
        Log.v(tag, finalMessage)
    }

    override fun d(tag: String, method: String, message: String) {
        val finalMessage = getFinalMessage(method, message)
        Log.d(tag, finalMessage)
    }

    override fun i(tag: String, method: String, message: String) {
        val finalMessage = getFinalMessage(method, message)
        Log.i(tag, finalMessage)
    }

    override fun w(tag: String, method: String, message: String) {
        val finalMessage = getFinalMessage(method, message)
        Log.w(tag, finalMessage)
    }

    override fun e(tag: String, method: String, message: String) {
        val finalMessage = getFinalMessage(method, message)
        Log.e(tag, finalMessage)
    }

    override fun wtf(tag: String, method: String, throwable: Throwable) {
        val finalMessage = getFinalMessage(method, throwable.message.orEmpty())

        Log.wtf(tag, finalMessage, throwable)
    }

    private fun getFinalMessage(method: String, message: String) = StringBuilder(method).apply {
        if (message.isNotEmpty()) append(LOG_SEPARATOR)
        append(message)
    }.toString()
}