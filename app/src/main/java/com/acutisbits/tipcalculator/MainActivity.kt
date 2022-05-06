package com.acutisbits.tipcalculator

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

private const val DEFAULT_EDIT_TEXT_VALUE = 0.0
private const val HUNDRED_PERCENT_DENOMINATOR = 100
private const val DOLLAR_SIGN = "$"

class MainActivity : AppCompatActivity() {

    private lateinit var tipAmount: TextView
    private lateinit var totalAmount: TextView
    private lateinit var billEditText: EditText
    private lateinit var tipPercentageEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialiseViews()
        setTextChangeListeners()
    }

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
}
