package part09

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 字节输入流转字符输入流
 * InputStreamReader
 */
fun main(args: Array<String>) {

    //字符流缓冲区
    var br: BufferedReader? = null

    try {
        //获取InputStream
        val `in` = System.`in`

        //字节流转换为字符流
        val isr = InputStreamReader(`in`)

        //创建字符流缓冲区
        br = BufferedReader(isr)

        while (true) {
            //读取一行
            val line = br.readLine() ?: break
            //当读到over时，结束循环
            if (line == "over") break
            //打印这行内容
            println(line)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (br != null) {
            try {
                br.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}