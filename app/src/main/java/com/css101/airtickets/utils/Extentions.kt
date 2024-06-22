package com.css101.airtickets.utils

fun Int.formatPrice(): String {
    val priceString = this.toString()
    return if (priceString.length >3) {
        priceString.substring(0, priceString.length - 3) + " " + priceString.substring(priceString.length - 3)
    } else {
        priceString
    }
}