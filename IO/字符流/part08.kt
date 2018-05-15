package part08

import java.io.BufferedReader
import java.io.FileReader

/**
 * BufferedReader
 */
fun main(args: Array<String>) {

    val fr: FileReader
    var br: BufferedReader? = null

    try {
        fr = FileReader("fileWriter.txt")
        br = BufferedReader(fr)

        while (true) {
            val line = br.readLine() ?: break
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