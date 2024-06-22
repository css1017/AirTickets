package com.css101.airtickets.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

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