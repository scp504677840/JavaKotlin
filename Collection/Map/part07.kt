package part07

import java.util.*

/**
 * Math
 */
fun main(args: Array<String>) {

    //PI
    println(Math.PI)//3.141592653589793

    //返回double大于或等于参数的最小（最接近负无穷大） 值，并且等于一个数学整数。
    println(Math.ceil(15.55))//16.0
    println(Math.ceil(-13.33))//-13.0

    //返回double小于或等于参数的最大（最接近正无穷大） 值，并且等于一个数学整数。
    println(Math.floor(12.34))//12.0
    println(Math.floor(-10.11))//-11.0

    //四舍五入
    println(Math.round(3.4))//3
    println(Math.round(3.5))//4

    //求次方的函数
    println(Math.pow(2.0, 3.0))//8.0

    //生成伪随机数
    println(Math.random())
    println((Math.random() * 10 + 1).toInt())

    //生成伪随机数
    val random = Random()
    println(random.nextInt())

}