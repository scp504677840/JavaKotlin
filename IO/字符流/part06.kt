package part08

import java.io.FileReader
import java.io.FileWriter

/**
 * 拷贝文本文件
 */
fun main(args: Array<String>) {

    var fw: FileWriter? = null
    var fr: FileReader? = null

    try {
        fw = FileWriter("demo.txt")
        fr = FileReader("fileWriter.txt")

        val cbuf = CharArray(1024)

        while (true) {
            val ch = fr.read(cbuf)
            if (ch == -1) break
            fw.write(cbuf, 0, ch)
        }

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (fw != null) {
            try {
                fw.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (fr != null) {
            try {
                fr.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}