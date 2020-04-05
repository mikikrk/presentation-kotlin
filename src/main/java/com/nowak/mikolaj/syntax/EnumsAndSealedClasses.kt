package com.nowak.mikolaj.syntax

enum class Types {
    ONE,
    TWO
}



sealed class SealesNames(
    val name: String
) {

    class FirstName(
        firstName: String
    ) : SealesNames(firstName)

    class FullName(
        firstName: String,
        secondName: String
    ) : SealesNames("$firstName $secondName")
}