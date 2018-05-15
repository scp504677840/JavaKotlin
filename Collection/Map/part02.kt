package part07

import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    /*var list = arrayListOf("aa", "zz", "cc", "bbb", "ll", "ee")
    list.forEach { print(it) }
    list.sort()
    println(list.maxWith(Comparator { o1, o2 -> o1.length - o2.length }))
    println(list.max())
    println()
    list.forEach { print(it) }*/

    /*
    //将集合中的所有元素替换为指定元素。
    val list = arrayListOf("aa", "zz", "cc", "bbb", "ll", "ee")
    list.forEach { print("$it,") }
    list.fill("pp")
    println()
    list.forEach { print("$it,") }*/

    val list = arrayListOf("aa", "zz", "cc", "bbb", "ll", "ee")
    //val synchronizedList = Collections.synchronizedList(list)

    //Collections.swap(list,0,1)
    //list.forEach { println(it) }

    //val set = list.set(0, "dd")
    //println(set)

    //swap
    //list[0] = list.set(1,list[0])
    //list.forEach { println(it) }

    /*val array = Array<Int>(5, { 0 })
    array.forEach { println(it) }
    val mutableList = Arrays.asList(array)
    mutableList.forEach { it.forEach { println(it) } }

    val nums = intArrayOf(1, 2, 3, 4, 5, 6)
    val numList = Arrays.asList(nums)
    numList.forEach { println(it) }*/

    show(1, 2, 3, 4, 5, 6, 7)
}

/**
 * 可变参数
 *
 * @param num 数字列表
 */
fun show(vararg num: Int) {
    num.forEach { println(it) }
}
