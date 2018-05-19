package io

import java.io.*
import java.util.*

/**
 * SequenceInputStream
 * 合并多个输入流
 */
fun main(args: Array<String>) {

    var sis: SequenceInputStream? = null
    var bos: BufferedOutputStream? = null

    try {
        val aBis = BufferedInputStream(FileInputStream("a.txt"))
        val bBis = BufferedInputStream(FileInputStream("b.txt"))
        val cBis = BufferedInputStream(FileInputStream("c.txt"))

        val vector = Vector<InputStream>()
        vector.addElement(aBis)
        vector.addElement(bBis)
        vector.addElement(cBis)

        sis = SequenceInputStream(vector.elements())
        bos = BufferedOutputStream(FileOutputStream("sis.txt"))

        val buf = ByteArray(1024)

        while (true) {
            val length = sis.read(buf)
            if (length == -1) break
            bos.write(buf, 0, length)
        }

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (sis != null) {
            try {
                sis.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (bos != null) {
            try {
                bos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}