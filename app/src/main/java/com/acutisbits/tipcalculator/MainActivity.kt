package com.acutisbits.tipcalculator

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

private const val DEFAULT_EDIT_TEXT_VALUE = 0.0
private const val HUNDRED_PERCENT_DENOMINATOR = 100

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tipAmount = findViewById<TextView>(R.id.tipAmount).apply {
            text = DEFAULT_EDIT_TEXT_VALUE.toString()
        }
        val totalAmount = findViewById<TextView>(R.id.totalAmount).apply {
            text = DEFAULT_EDIT_TEXT_VALUE.toString()
        }

        val billEditText = findViewById<EditText>(R.id.billAmountEditText)
        val tipPercentageEditText = findViewById<EditText>(R.id.tipPercentageEditText).apply {
            filters = arrayOf(PercentageNumberFilter())
        }

        billEditText.doAfterTextChanged {
            val billAmount = it?.toString()?.toDoubleOrNull() ?: DEFAULT_EDIT_TEXT_VALUE
            val tipPercentageAmount = tipPercentageEditText.text.toString().toDoubleOrNull() ?: DEFAULT_EDIT_TEXT_VALUE

            calculateTipAndTotalAmount(billAmount, tipPercentageAmount, tipAmount, totalAmount)
        }

        tipPercentageEditText.doAfterTextChanged {
            val tipPercentageAmount = it?.toString()?.toDoubleOrNull() ?: DEFAULT_EDIT_TEXT_VALUE
            val billAmount = billEditText.text.toString().toDoubleOrNull() ?: DEFAULT_EDIT_TEXT_VALUE

            calculateTipAndTotalAmount(billAmount, tipPercentageAmount, tipAmount, totalAmount)
        }
    }

    private fun calculateTipAndTotalAmount(
        billAmount: Double,
        tipPercentageAmount: Double,
        tipAmount: TextView,
        totalAmount: TextView
    ) {
        val tipAmountCalculated = billAmount * tipPercentageAmount / HUNDRED_PERCENT_DENOMINATOR
        tipAmount.text = tipAmountCalculated.toString()

        val totalAmountCalculated = billAmount + tipAmountCalculated
        totalAmount.text = totalAmountCalculated.toString()
    }
}