package io

import java.io.CharArrayReader
import java.io.CharArrayWriter

/**
 * 操作字符数组的流
 */
fun main(args: Array<String>) {

    //数据源
    val car = CharArrayReader("AABBCC".toCharArray())
    //数据目的
    val caw = CharArrayWriter()

    val buf = CharArray(1024)

    while (true) {
        val length = car.read(buf)
        if (length == -1) break
        caw.write(buf, 0, length)
    }

    println(caw.size())
    println(caw.toString())

}