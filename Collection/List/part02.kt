package part06

import java.util.*

fun main(args: Array<String>) {

    val linkedList = LinkedList<Int>()

    linkedList.add(11)
    linkedList.add(22)
    linkedList.add(33)
    linkedList.add(44)
    linkedList.add(55)

    println("linkedList.first:${linkedList.first}")
    println("linkedList.last:${linkedList.last}")

    linkedList.addFirst(10)
    linkedList.addLast(66)

    //删除元素并取出该元素
    val first = linkedList.removeFirst()
    val last = linkedList.removeLast()
    println("first:$first,last:$last")

    //获取元素并删除
    val pollFirst = linkedList.pollFirst()
    val pollLast = linkedList.pollLast()
    val poll = linkedList.poll()
    println("pollFirst:$pollFirst,pollLast:$pollLast,poll:$poll")

    //获取元素不删除
    val peekFirst = linkedList.peekFirst()
    val peekLast = linkedList.peekLast()
    val peek = linkedList.peek()
    println("peekFirst:$peekFirst,peekLast:$peekLast,peek:$peek")

    val iterator = linkedList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

}