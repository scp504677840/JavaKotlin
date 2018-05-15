package part09

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 字节输出流转字符输出流
 * OutputStreamWriter
 */
fun main(args: Array<String>) {

    var br: BufferedReader? = null
    var bw: BufferedWriter? = null

    try {
        br = BufferedReader(InputStreamReader(System.`in`))
        bw = BufferedWriter(OutputStreamWriter(System.out))

        while (true) {
            val line = br.readLine() ?: break
            if (line == "over") break
            bw.write(line.toUpperCase())
            bw.newLine()
            bw.flush()
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
        if (bw != null) {
            try {
                bw.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}