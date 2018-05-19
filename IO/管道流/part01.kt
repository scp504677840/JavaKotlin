package io

import java.io.PipedInputStream
import java.io.PipedOutputStream

/**
 * 管道流
 */
fun main(args: Array<String>) {

    val pis = PipedInputStream()
    val pos = PipedOutputStream()

    //连接
    pis.connect(pos)

    val read = Read(pis)
    val write = Write(pos)

    Thread(read).start()
    Thread(write).start()

}

private class Read(val pis: PipedInputStream) : Runnable {
    val buf = ByteArray(1024)
    override fun run() {
        try {
            println("写入前。。。")
            Thread.sleep(6000)
            val length = pis.read(buf)
            println(String(buf, 0, length))
            println("写入后。。。")
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                pis.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

private class Write(val pos: PipedOutputStream) : Runnable {
    override fun run() {
        try {
            println("读取。。。")
            pos.write("aabbcc".toByteArray())
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                pos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}