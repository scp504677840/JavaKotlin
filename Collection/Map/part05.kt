package part07

import java.text.SimpleDateFormat
import java.util.*

/**
 * Date
 */
fun main(args: Array<String>) {

    val date = Date()
    println(date)

    val sdf = SimpleDateFormat("yyyy年MM月dd日E hh:mm:ss")
    val format = sdf.format(date)
    println(format)

}