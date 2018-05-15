package part08

import java.io.FileReader
import java.io.LineNumberReader

fun main(args: Array<String>) {

    var lnr: LineNumberReader? = null

    try {
        lnr = LineNumberReader(FileReader("fileWriter.txt"))

        //设置起始行号
        //lnr.lineNumber = 100

        while (true) {
            val line = lnr.readLine() ?: break
            println("${lnr.lineNumber}:$line")
        }

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (lnr != null) {
            try {
                lnr.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}