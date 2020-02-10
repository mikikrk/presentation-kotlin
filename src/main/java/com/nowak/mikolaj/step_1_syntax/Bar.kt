package com.nowak.mikolaj.step_1_syntax

import com.nowak.mikolaj.JavaSandbox
import java.io.Serializable
import java.lang.IllegalStateException

open class Super(
    open val id: Int?
) : SuperInterface {
    override lateinit var name: String
    private val upperName: String by lazy { name.toUpperCase() }

    override fun superFoo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

interface SuperInterface {
    val name: String

    fun superFoo()
}

class Bar(
    id: Int?,
    override var name: String
) : SuperInterface by Super(id),
    Serializable {

    val strId = id.toString()
    var nullId: Int? = 1

    init {
        val nonNullBar: Bar = JavaSandbox().bar
        val nullBar: Bar? = JavaSandbox().bar
        val javaBar = JavaSandbox().bar

        nullId?.let {
            foo(it)
        }
        nullId?.let { nonNullId ->
            foo(nonNullId)
        }
        nullId?.let(this::foo)

        var nullId: Int? = 1
        nullId = null
        if (nullId != null) {
            foo(nullId)
        }
        requireNotNull(id, { "Its on one thread with check right before the call" }).dec()
    }

    fun foo(id: Int) {
        superFoo()
        id = 1
    }

    fun foo2(id: Int) =
        if (id > 30) {
            id.toString()
        } else {
            id.toShort()
        }

    fun foo3(id: Int) =
        when (id) {
            1 -> id.toString()
            2 -> id.toShort()
            else -> id.toLong()
        }

    fun foo3(id: Any?) =
        when (id) {
            null -> id.toString()
            is Bar -> id.strId
            1 > 3 -> 4
            id.hashCode() > 2 -> {
                val a = id.toString()
                a.length
            }
            else -> id
        }

    fun foo4(id: Any?) =
        when {
            1 > 3 -> 4
            id.hashCode() > 2 -> {
                val a = id.toString()
                a.length
            }
            else -> id
        }

    fun foo5(id: Any?) =
        try {
            if (id is Bar) {
                4
            } else {
                throw IllegalStateException()
            }
        } catch (e: Throwable) {
        }

    fun foo6(): Unit {
    }

    fun foo7(): Unit = print("")

    inline fun foo8(block: () -> Unit) {
        block.invoke()
        block()
    }

    fun foo9(block: (() -> Unit)?) {
        block?.invoke()
    }

    fun show() {
        foo9({
            return Unit
        })
        foo9 {
        }
        foo9(null)
        foo9(this::foo10)
    }

    fun foo10() {
    }

    var longIdInner: String = ""
        get() = longId.toString()
        set(value) {
            field = value + "?"
            field = "$value?"
        }

    operator fun plusAssign(bar: Any) {
    }

    fun getItem(list: List<out Int>): Int =
        list[0]

    fun appendItem(list: MutableList<in Int>, item: Int) {
        list[0] = item
    }

    fun getInItem(list: List<in Int>): Int =
        list[0]

    fun appendOutItem(list: MutableList<out Int>, item: Int) {
        list[0] = item
    }

    internal interface Holder<out T : Super> {
        fun get(): T
        fun add(t: T)
    }

    internal fun foo(holder: Holder<*>) {
        val objectHolder: Holder<Super> = holder

    }

    const val URL = "http"

    companion object {
        const val NAME = "Bar"

        @JvmField
        val sth = ""

        @JvmStatic
        fun foon() = Unit
    }
}

inline fun <reified T> createSuper(number: Int): T? =
    if (number is T) {
        number
    } else {
        T::class.objectInstance
    }

fun Bar.foo11() =
    strId + name

infix fun Any.to(any: Any) =
    Pair(this, any)

fun Bar.infixUsage() =
    strId to name

fun Bar?.foo12() =
    this?.strId + this?.name

inline val Bar?.longId
    get() = this?.id?.toLong() ?: 0L

inline var Bar?.longIdVar
    get() = this?.id?.toLong() ?: 0L
    set(value) {
        this?.name = value.toString()
    }

inline fun Bar.foo13(block: Bar.() -> Any?): Any =
    block() ?: Unit

val bar: Bar? = Bar(1, "name")
fun showcase() {
    Bar(1, "name").foo13 { id }
    val letResult: Int? = bar?.let {
        it.id
    }
    val alsoResult: Bar? = bar?.also {
        it.id
    }
    val firstId = listOf<Bar>()
        .map { it.id }
        .first()
        .also { bar.longIdVar = it?.toLong() ?: 0L }

    val applyResult: Bar? = bar?.apply {
        id
    }
    val barVal: Bar = Bar(2, "name").apply {
        longIdInner = "4"
        foo(2)
    }
    val barVal2 = Bar(2, "name")
    barVal2.longIdInner = "4"
    barVal2.foo(2)

    val withResult: Int? = with(bar) {
        this?.id
    }

    val runResult: Int? = bar?.run {
        id
    }
    var list = listOf<Any?>() + listOf<Any>() + Any()
    list += listOf<Unit>()
    list += null
}

fun createBar() = Bar(2, "n").apply {
    longIdInner = "4"
}

object Utils {
    const val URL = "http"
    const val BAR: Bar = Bar(0, "")
}

class Bar2 @JvmOverloads constructor(
    id: Int? = null,
    override var name: String = "BAR",
    val age: Int = 0
) : Super(id), Serializable

fun createBar(id: Int? = 0) =
    Bar2(
        id = null,
        "Default",
        age = 0
    )