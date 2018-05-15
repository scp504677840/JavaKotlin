package part06

import java.util.*

fun main(args: Array<String>) {

    val duiLie = DuiLie()
    duiLie.add(11)
    duiLie.add(22)
    duiLie.add(33)
    duiLie.add(44)
    duiLie.add(55)

    val iterator = duiLie.iterator()
    while (iterator.hasNext()){
        println(iterator.next())
    }

    /*println(duiLie.get())
    println(duiLie.get())
    println(duiLie.get())
    println(duiLie.get())
    println(duiLie.get())
    println(duiLie.get())*/

}

private class DuiLie {

    private val list = LinkedList<Int>()

    fun add(e: Int) {
        list.addFirst(e)
    }

    fun get(): Int {
        return list.peekLast()
    }

    fun iterator(): MutableIterator<Int> {
        return list.iterator()
    }

}