package part07

/**
 * System
 */
fun main(args: Array<String>) {
    //设置属性信息
    System.setProperty("mykey","myvalue")

    //获取所有属性信息
    val properties = System.getProperties()
    properties.forEach { println("${it.key} : ${it.value}") }

    //获取指定属性信息
    val property = System.getProperty("mykey")
    println(property)


}