package part10

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*

/**
 * 可以事先建好lab.properties文件并写入如下值：
 * width=10
 * height=20
 */
fun main(args: Array<String>) {

    try {
        val file = File("lab.properties")
        if (!file.exists()) {
            println("文件不存在")
            file.createNewFile()
        }

        val properties = Properties()
        properties.load(FileInputStream(file))
        val propertyNames = properties.propertyNames()
        while (propertyNames.hasMoreElements()) {
            val key = propertyNames.nextElement() as String
            val value = properties[key] as String
            println("key:$key,value:$value")
            properties.setProperty(key, value.toInt().plus(1).toString())
        }

        properties.store(FileOutputStream(file), "close")

    } catch (e: Exception) {
        e.printStackTrace()
    }

}