package part05

fun main(args: Array<String>) {
    val str = "abcbaCBA"

    println("字符串长度：${str.length}")

    println("lastIndex：${str.lastIndex}")
    println("indexOf1：${str.indexOf('a')}")
    println("indexOf2：${str.indexOf('a', 3)}")
    println("indexOf3：${str.indexOf('a', 5, true)}")
    println("indexOfFirst：${str.indexOfFirst { it == 'a' }}")
    println("indexOfLast：${str.indexOfLast { it == 'a' }}")
    println("indexOfAny1：${str.indexOfAny("cCa".toCharArray())}")
    println("indexOfAny2：${str.indexOfAny(arrayListOf("CBA"))}")
    println("intern：${str.intern()}")
    println("c的位置：${str}")

    println("c的位置：${str.lastIndex}")
}