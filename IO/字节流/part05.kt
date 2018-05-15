package part09

import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream

/**
 * BufferedOutputStream
 * BufferedInputStream
 *
 * 1.注意理解为什么BufferedInputStream的read返回的值是Int类型而不是Byte类型？
 * 提示：BufferedOutputStream的write方法将read返回Int强转为Byte类型。
 */
fun main(args: Array<String>) {

    var bos: BufferedOutputStream? = null
    var bis: BufferedInputStream? = null

    try {
        bos = BufferedOutputStream(FileOutputStream("abc.jpg"))
        bis = BufferedInputStream(FileInputStream("me.jpg"))

        while (true) {
            val byte = bis.read()
            if (byte == -1) break
            bos.write(byte)
        }

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (bos != null) {
            try {
                bos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (bis != null) {
            try {
                bis.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}