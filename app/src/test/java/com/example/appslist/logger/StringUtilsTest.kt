package com.example.appslist.logger

import com.example.appslist.common.formatSize
import com.example.appslist.common.getFormattedDate

import org.junit.Test

import org.junit.Assert.*

class StringUtilsTest {
    @Test
    fun `when format is valid return day of the year`() {
        val input = "2023-11-23 12:34:56"
        val expectedOutput = "2023-11-23"
        val actualOutput = input.getFormattedDate()
        assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `invalid format should return empty string`() {
        val invalidInput = "invalid-date"
        val result = invalidInput.getFormattedDate()
        assertEquals("", result)
    }

    @Test
    fun `should return correct format on bytes`() {
        val size = "123"
        val expected = "123 B"
        val actual = size.formatSize()
        assertEquals(expected, actual)
    }

    @Test
    fun `should return correct format on kilo bytes`() {
        val size = "51200" //1024 * 50L // 50 KB
        val expected = "50 KB"
        val actual = size.formatSize()
        assertEquals(expected, actual)
    }

    @Test
    fun `should return correct format on mega bytes`() {
        val size = "2097152" //1024 * 1024 * 2L // 2 MB
        val expected = "2 MB"
        val actual = size.formatSize()
        assertEquals(expected, actual)
    }

    @Test
    fun testInvalidInput() {
        val invalidSize = "not a number"
        val expected = ""
        val actual = invalidSize.formatSize()
        assertEquals(expected, actual)
    }
}