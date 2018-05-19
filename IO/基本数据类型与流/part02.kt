package io

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

/**
 * 操作字节数组的流对象
 * 注意：
 * ByteArrayInputStream和ByteArrayOutputStream都不涉及操作底层文件，所以不需要关闭流。
 */
fun main(args: Array<String>) {

    //数据源
    val bais = ByteArrayInputStream("ABCD".toByteArray())
    //数据目的
    val baos = ByteArrayOutputStream()

    val buf = ByteArray(1024)
    while (true) {
        val length = bais.read(buf)
        if (length == -1) break
        baos.write(buf, 0, length)
    }

    println(baos.size())
    println(baos.toString())

}
