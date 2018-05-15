package part09

import java.io.FileInputStream

fun main(args: Array<String>) {

    var fis: FileInputStream? = null
    try {
        fis = FileInputStream("fos.txt")

        //实际可读字节数，也就是总大小。
        val available = fis.available()
        println(available)//1280

        val buf = ByteArray(1024)

        while (true) {
            val length = fis.read(buf)
            if (length == -1) break
            println(String(buf, 0, length))
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