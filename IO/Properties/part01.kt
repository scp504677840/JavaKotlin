package part10

import java.util.*

fun main(args: Array<String>) {

    val properties = Properties()
    properties.setProperty("name","tom")
    properties.setProperty("age","12")

    println(properties)
    println(properties["name"])

    val names = properties.stringPropertyNames()
    names.forEach { println(properties[it]) }

}