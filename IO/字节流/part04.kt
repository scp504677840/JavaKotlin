package part09

import java.io.FileInputStream
import java.io.FileOutputStream

/**
 * 拷贝图片
 */
fun main(args: Array<String>) {

    var fos: FileOutputStream? = null
    var fis: FileInputStream? = null

    try {
        fos = FileOutputStream("abc.jpg")
        fis = FileInputStream("me.jpg")

        val buf = ByteArray(1024)
        while (true) {
            val length = fis.read(buf)
            if (length == -1) break
            fos.write(buf, 0, length)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (fos != null) {
            try {
                fos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (fis != null) {
            try {
                fis.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}