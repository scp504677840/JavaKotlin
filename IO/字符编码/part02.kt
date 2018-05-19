package io

import java.io.*

/**
 * 尝试不同字符编码存入文件
 */
fun main(args: Array<String>) {

    writeGBK()
    writeUTF()

    readGBK()
    readUTF()

}

private fun readUTF() {
    var br: BufferedReader? = null
    try {
        br = BufferedReader(InputStreamReader(FileInputStream("utf.txt"), "utf-8"))
        //乱码
        //br = BufferedReader(InputStreamReader(FileInputStream("utf.txt"), "gbk"))
        val buf = CharArray(1024)
        while (true) {
            val length = br.read(buf)
            if (length == -1) break
            println(String(buf, 0, length))
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

private fun readGBK() {
    var br: BufferedReader? = null

    try {
        br = BufferedReader(InputStreamReader(FileInputStream("gbk.txt"), "gbk"))
        //乱码
        //br = BufferedReader(InputStreamReader(FileInputStream("gbk.txt"), "utf-8"))
        val buf = CharArray(1024)
        while (true) {
            val length = br.read(buf)
            if (length == -1) break
            println(String(buf, 0, length))
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

private fun writeUTF() {
    var bw: BufferedWriter? = null
    try {
        bw = BufferedWriter(OutputStreamWriter(FileOutputStream("utf.txt"), "utf-8"))
        bw.write("你好")
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (bw != null) {
            try {
                bw.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

private fun writeGBK() {

    var bw: BufferedWriter? = null

    try {
        bw = BufferedWriter(OutputStreamWriter(FileOutputStream("gbk.txt"), "gbk"))
        bw.write("你好")
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (bw != null) {
            try {
                bw.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}
