package part09

import java.io.FileInputStream

fun main(args: Array<String>) {

    var fis: FileInputStream? = null
    try {
        fis = FileInputStream("fos.txt")

        //println(fis.read().toChar())//a
        //println(fis.read().toChar())//b
        //println(fis.read().toChar())//c
        //println(fis.read())//-1

        while (true) {
            val ch = fis.read()
            if (ch == -1) break
            println(ch.toChar())
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (fis != null) {
            try {
                fis.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}