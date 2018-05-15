package part06

import java.util.*

fun main(args: Array<String>) {
    //双端队列
    val arrayDeque: Deque<Int> = ArrayDeque<Int>()
    arrayDeque.addFirst(11)
    arrayDeque.addFirst(22)
    arrayDeque.addFirst(33)
    arrayDeque.addFirst(44)
    arrayDeque.addLast(555)
    arrayDeque.addLast(666)

    //入栈，在栈顶
    arrayDeque.push(77)
    //出栈，删除元素并返回
    val pop = arrayDeque.pop()
    println("pop:$pop")

    val iterator = arrayDeque.iterator()
    while (iterator.hasNext()){
        println(iterator.next())
    }
}