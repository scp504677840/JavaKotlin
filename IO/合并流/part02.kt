package io

import java.io.*
import java.util.*

/**
 * 切割文件并合并
 */
fun main(args: Array<String>) {

    //切割
    //split()

    //合并
    merge()

}

private fun merge() {

    var bos: BufferedOutputStream? = null
    var sis: SequenceInputStream? = null

    try {
        bos = BufferedOutputStream(FileOutputStream("newbg.png"))

        val list = ArrayList<FileInputStream>()
        list.add(FileInputStream("1.part"))
        list.add(FileInputStream("2.part"))
        list.add(FileInputStream("3.part"))
        list.add(FileInputStream("4.part"))
        list.add(FileInputStream("5.part"))
        list.add(FileInputStream("6.part"))
        list.add(FileInputStream("7.part"))

        val iterator = list.iterator()

        val enumeration = object : Enumeration<FileInputStream> {
            override fun hasMoreElements(): Boolean = iterator.hasNext()
            override fun nextElement(): FileInputStream = iterator.next()
        }

        sis = SequenceInputStream(enumeration)

        //1KB
        val buf = ByteArray(1024)

        while (true) {
            val length = sis.read(buf)
            if (length == -1) break
            bos.write(buf, 0, length)
        }

        // 注意：切割大型文件时，比如：电影（2GB）
        // 此时就不要创建100MB的缓冲区val buf = ByteArray(1024 * 1024 * 100) ，以免发生内存溢出，
        // 可以创建一个1MB的缓冲区，然后控制写入次数（比如往同一个文件.part写入100次，这样就达到同样的目的）。
        // 伪代码：
        /*val buf = ByteArray(1024 * 1024)
        var count = 1
        while (true) {
            val length = sis.read(buf)
            if (length == -1) break
            if (count>=100){
                bos = BufferedOutputStream(FileOutputStream("${count++}.part"))
            }
            bos.write(buf, 0, length)
        }*/

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
        if (sis != null) {
            try {
                sis.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}

private fun split() {

    var bis: BufferedInputStream? = null

    try {
        bis = BufferedInputStream(FileInputStream("bg.png"))

        //1KB
        val buf = ByteArray(1024)
        var count = 1

        while (true) {
            val length = bis.read(buf)
            if (length == -1) break
            val fos = FileOutputStream("${count++}.part")
            fos.write(buf, 0, length)
            fos.close()
        }

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (bis != null) {
            try {
                bis.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}
