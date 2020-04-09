package com.nowak.mikolaj

enum class Types(val namee: String) {
    ONE(""),
    TWO(""),
    THREE("")
}



sealed class SealesNames(
    val name: String
) {

    init {
    }
    class FirstName(
        val firstName: String
    ) : SealesNames(firstName)

    class FullName(
        firstName: String,
        val secondName: String
    ) : SealesNames("$firstName $secondName")

    class S: SealesNames("")
}