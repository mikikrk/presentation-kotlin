package com.nowak.mikolaj.generics

import java.util.*

class ExtendsSuper {
    internal interface Super {
        fun superMethod(): Super?
    }

    interface Child : Super {
        fun childMethod(): Child
    }

    internal interface ChildOfChild : Child {
        fun childOfChildMethod(): ChildOfChild?
    }

    fun getExtends(list: List<Child>, index: Int): Child {
        return list[index].childMethod()
    }

    fun getSupers(list: List<in Child>, item: Int): Child {
        return list[item].childMethod()
    }

    fun getting() {
        getExtends(ArrayList<Super>(), 0)
        getExtends(ArrayList(), 0)
        getExtends(ArrayList<ChildOfChild>(), 0)
        getSupers(ArrayList<Super>(), 0)
        getSupers(ArrayList<Child>(), 0)
        getSupers(ArrayList<ChildOfChild>(), 0)
    }

    fun appendExtends(
        list: MutableList<out Child?>,
        item: Child?
    ) {
        list.add(item)
    }

    val pair: Pair<Int, Int> = 1 to 1

    fun appendSupers(
        list: MutableList<in Child?>,
        item: Child?
    ) {
        list.add(item)
    }

    private val child: Child? = null
    fun appending() {
        appendExtends(ArrayList<Super?>(), child)
        appendExtends(ArrayList(), child)
        appendExtends(ArrayList<ChildOfChild?>(), child)
        appendSupers(ArrayList<Super?>(), child)
        appendSupers(ArrayList(), child)
        appendSupers(ArrayList<ChildOfChild?>(), child)
    }
}

inline fun <reified T> create(number: Int): T? =
    if (number is T) {
        number
    } else {
        T::class.objectInstance
    }