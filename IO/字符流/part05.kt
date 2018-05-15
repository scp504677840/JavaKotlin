package part08

import java.io.FileReader

fun main(args: Array<String>) {

    var fr: FileReader? = null

    try {
        fr = FileReader("fileWriter.txt")
        val cbuf = CharArray(1024)
        while (true) {
            val ch = fr.read(cbuf)
            if (ch == -1) break
            println(String(cbuf, 0, ch))
        }

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (fr != null) {
            try {
                fr.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}