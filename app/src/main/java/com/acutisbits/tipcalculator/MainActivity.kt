package com.acutisbits.tipcalculator

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.acutisbits.tipcalculator.utils.DEFAULT_EDIT_TEXT_VALUE
import com.acutisbits.tipcalculator.utils.DOLLAR_SIGN
import com.acutisbits.tipcalculator.utils.HUNDRED_PERCENT_DENOMINATOR

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

/*
    private fun initialiseViews() {
        tipAmount = findViewById<TextView>(R.id.tipAmount).apply {
            text = DEFAULT_EDIT_TEXT_VALUE.toString()
        }
        totalAmount = findViewById<TextView>(R.id.totalAmount).apply {
            text = DEFAULT_EDIT_TEXT_VALUE.toString()
        }

        billEditText = findViewById(R.id.billAmountEditText)
        tipPercentageEditText = findViewById<EditText>(R.id.tipPercentageEditText).apply {
            filters = arrayOf(PercentageNumberFilter())
        }
    }

    private fun setTextChangeListeners() {
        billEditText.doAfterTextChanged { editableText ->
            val billAmount = editableText?.toString()?.toDoubleOrNull() ?: DEFAULT_EDIT_TEXT_VALUE
            val tipPercentageAmount = tipPercentageEditText.text.toString().toDoubleOrNull() ?: DEFAULT_EDIT_TEXT_VALUE

            calculateTipAndTotalAmount(billAmount, tipPercentageAmount, tipAmount, totalAmount)
        }

        tipPercentageEditText.doAfterTextChanged { editableText ->
            val tipPercentageAmount = editableText?.toString()?.toDoubleOrNull() ?: DEFAULT_EDIT_TEXT_VALUE
            val billAmount = billEditText.text.toString().toDoubleOrNull() ?: DEFAULT_EDIT_TEXT_VALUE

            calculateTipAndTotalAmount(billAmount, tipPercentageAmount, tipAmount, totalAmount)
        }
    }

    private fun calculateTipAndTotalAmount(
        billAmount: Double,
        tipPercentageAmount: Double,
        tipAmount: TextView,
        totalAmount: TextView,
        currency: String = DOLLAR_SIGN
    ) {
        val tipAmountCalculated = billAmount * tipPercentageAmount / HUNDRED_PERCENT_DENOMINATOR
        val tipAmountWithCurrency = "$currency$tipAmountCalculated"
        tipAmount.text = tipAmountWithCurrency

        val totalAmountCalculated = billAmount + tipAmountCalculated
        val totalAmountWithCurrency = "$currency$totalAmountCalculated"
        totalAmount.text = totalAmountWithCurrency
    }
    */
}
