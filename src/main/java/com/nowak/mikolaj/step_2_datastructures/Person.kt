package com.nowak.mikolaj.step_2_datastructures

data class Person(
    @JvmField
    val id: Int?,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val money: Double?,
    val animals: List<String>,
    val addresses: Map<String, String>
)
