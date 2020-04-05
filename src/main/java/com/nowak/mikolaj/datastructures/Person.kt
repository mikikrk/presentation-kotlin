package com.nowak.mikolaj.datastructures

data class Person(
    val id: Int,
    val firstName: String,
    val lastName: Long
)

fun foo() {
    val person = Person(1, "Jon", "smith")
    val isTrue = person != person.copy(firstName = "Adam")

    val (id: Int, lastName: Long) = person

}
