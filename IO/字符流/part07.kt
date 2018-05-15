package part08

import java.io.BufferedWriter
import java.io.FileWriter

/**
 * BufferedWriter
 */
fun main(args: Array<String>) {

    val fw: FileWriter?
    var bw: BufferedWriter? = null
    try {
        fw = FileWriter("fileWriter.txt")

        //创建写入流缓冲区
        bw = BufferedWriter(fw)
        bw.write("aabbcc")
        bw.newLine()
        bw.write("ddeeff")
        //缓冲区一定要刷新
        bw.flush()

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        //bw.close()实际关闭的是FileWriter，所以FileWriter不用单独关闭。
        if (bw != null) {
            try {
                bw.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}