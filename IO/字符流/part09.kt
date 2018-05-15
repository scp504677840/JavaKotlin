package part08

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter

/**
 * BufferedWriter
 * BufferedReader
 * 拷贝文本文件
 */
fun main(args: Array<String>) {

    var bw: BufferedWriter? = null
    var br: BufferedReader? = null

    try {
        bw = BufferedWriter(FileWriter("demo.txt"))
        br = BufferedReader(FileReader("fileWriter.txt"))

        while (true) {
            val line = br.readLine() ?: break
            bw.write(line)
            bw.flush()
            bw.newLine()
        }

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (bw != null) {
            try {
                bw.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (br != null) {
            try {
                br.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}