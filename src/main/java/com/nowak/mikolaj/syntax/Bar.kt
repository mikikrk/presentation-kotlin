package com.nowak.mikolaj.syntax

import com.nowak.mikolaj.JavaSandbox
import java.io.Serializable

abstract class Super(
    id: Int
) {

}

class Bar(
     private val id: String
) : Super(id.toInt()), Serializable {

    var name: String = "Jon"

    private val name3: String? = null

    init {
        id
    }

    fun foo() {
        val bar: Bar = JavaSandbox().bar

        name?.let(::foo2)
    }

    fun foo2(name: String) {

    }
}