package com.nowak.mikolaj.syntax

import java.io.Serializable
import java.lang.reflect.Type

class Super(
    private val id: Int
) : Inter {

    var name: String? = ""

    override fun foo() {
        name?.let { it }
    }
}

interface Inter {

    fun foo()
}

class Bar<T: Inter>(
    private val id: String?,
    private val superClass: Super = Super(id.toInt())
) : Inter by superClass,
    Serializable {

    @JvmField
    val name: String =""

    override fun foo() {
        foo2(1) { name ->
            name
        }
        id.apply {
            ""
        }
        val mutableList = mutableListOf(1, 2, 3)
        foo3(
            mutableList
                .toList()
        )
        mutableList.add(1)
    }

    operator fun plusAssign(id: Int){}
    operator fun plusAssign(id: String){}

    fun foo3(list: List<Int>) {
        val ml: List<Int?> = list + listOf(4) + 4 + listOf<Int?>(1, null)
    }

    fun create(): Super =
        Super(1)
            .apply {
                name = "1"
                foo()
            }

    fun foo2(id: Int, s: SimpleLambda = {}, lambda: ((String) -> String)? = { "" }) {
        println()
        lambda?.invoke("")
        isZero { (names, id) ->
            names
        }
    }

    companion object {

        @JvmStatic
        fun companionFoo(){

        }
    }
}

data class Sss (
    val name: String = "",
    val id: Int?
)

fun Super?.isZero(lambda: (Sss) -> String) {
    Singleton.id
}

typealias SimpleLambda = () -> Unit

object Singleton {

    const val id: Int =1
    fun foo() {

    }

}