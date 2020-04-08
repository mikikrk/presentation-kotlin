package com.nowak.mikolaj.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class Price(
    val id: String
)

fun computePrice(price: Price) {
    // show price
}

suspend fun fetchPriceCoroutines(): Price =
    withContext(Dispatchers.IO) {
        // make network call
        // return price
        createPrice()
    }

fun createPrice() = Price("id")

fun coroutinesStyle() {
    GlobalScope.launch(Dispatchers.Default) {
        val price = fetchPriceCoroutines()
        computePrice(price)
    }
}