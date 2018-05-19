package io

import java.io.StringReader
import java.io.StringWriter

/**
 * 操作字符串的流
 */
fun main(args: Array<String>) {

    val sr = StringReader("ABCDEFG")
    val sw = StringWriter()

    val buf = CharArray(1024)

    while (true) {
        val length = sr.read(buf)
        if (length == -1) break
        sw.write(buf, 0, length)
    }

    println(sw.buffer)
    println(sw.toString())

}