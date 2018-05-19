package io

import java.nio.charset.Charset
import java.util.*

fun main(args: Array<String>) {

    //UTF-8:[-28, -67, -96, -27, -91, -67]
    //GBK:[-60, -29, -70, -61]
    val str = "你好"

    //编码
    val bytes = str.toByteArray(Charset.forName("gbk"))

    println(Arrays.toString(bytes))

    //解码
    var value = String(bytes, Charset.forName("gbk"))
    println(value)

    //解码
    value = String(bytes, Charset.forName("utf-8"))
    println(value)

}