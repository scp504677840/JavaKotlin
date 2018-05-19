package io

import java.io.RandomAccessFile

/**
 * 随机访问文件RandomAccessFile
 * 1.读取与写入
 * 2.继承自Object
 */
fun main(args: Array<String>) {

    //写入
    write()

    //读取
    read()
}

private fun read() {
    var raf: RandomAccessFile? = null

    try {
        raf = RandomAccessFile("fw.txt", "r")

        //情况一：普通读取
        /*val buf = ByteArray(1024)
        while (true) {
            val length = raf.read(buf)
            if (length == -1) break
            println(String(buf, 0, length))
        }*/

        //情况二：指定位置读取
        //指针指到下标为10这个位置，为什么是10？
        //李四：一个中文占3个字节，所以两个中文占6个字节；
        //97：一个Int占4个字节；
        //所以加起来总共10个字节，下标为9，因为下标是从0开始的；指到下标为10的位置说明就是从新的位置开始计算。
        /*raf.seek(10)
        //读两个中文，6个字节。
        val buf = ByteArray(6)
        val length = raf.read(buf)
        println(String(buf, 0, length))*/

        //情况三：跳过多少个字节开始读。
        //上面是从指定位置（下标）开始读取。
        //此处是跳过多少个字节开始读取。
        raf.skipBytes(20)
        val buf = ByteArray(6)
        val length = raf.read(buf)
        println(String(buf, 0, length))


    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (raf != null) {
            try {
                raf.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

private fun write() {
    var raf: RandomAccessFile? = null

    try {
        raf = RandomAccessFile("fw.txt", "rw")

        //情况一：普通写入
        raf.write("李四".toByteArray())
        //raf.write(97)
        //raf.write(258)
        raf.writeInt(97)

        raf.write("王五".toByteArray())
        raf.writeInt(99)

        //情况二：指定位置写入
        raf.seek(0)
        raf.write("赵六".toByteArray())
        raf.writeInt(98)

        //情况三：跳过多少个字节开始写入，测试时并没有发现跳过多少个字节开始写入
        raf.skipBytes(20)
        raf.write("田七".toByteArray())
        raf.writeInt(100)

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (raf != null) {
            try {
                raf.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
