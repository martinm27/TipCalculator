package com.acutisbits.tipcalculator.utils

import android.text.InputFilter
import android.text.Spanned

// Custom class to define min and max for the edit text
class PercentageNumberFilter : InputFilter {

    private val min = 0.0
    private val max = 100.0

    override fun filter(
        source: CharSequence?,
        p1: Int,
        p2: Int,
        destination: Spanned?,
        p4: Int,
        p5: Int
    ): CharSequence? {
        try {
            val input = (destination.toString() + source.toString()).toDouble()
            if (input in min..max) {
                return null
            }
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }
        return ""
    }
}
