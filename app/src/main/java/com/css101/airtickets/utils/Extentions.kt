package com.css101.airtickets.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Int.formatPrice(): String {
    val priceString = this.toString()
    return if (priceString.length >3) {
        priceString.substring(0, priceString.length - 3) + " " + priceString.substring(priceString.length - 3)
    } else {
        priceString
    }
}
fun View.showKeyboard() {
    this.requestFocus()
    this.postDelayed({
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }, 300)
}

fun Date.formatShort(): String {
    val dateFormat = SimpleDateFormat("dd MMM, EEE", Locale("ru"))
    return dateFormat.format(this)
}
fun Date.formatLong(): String {
    val dateFormat = SimpleDateFormat("dd MMMM", Locale("ru"))
    return dateFormat.format(this)
}