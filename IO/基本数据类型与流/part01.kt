package io

import java.io.*

/**
 * 操作基本数据类型
 *
 * 基本数据类型与流
 */
fun main(args: Array<String>) {

    //写普通数据类型
    //write()

    //读普通数据类型
    //read()

    //特殊：写UTF-8修改版
    writeUtf()

    //特殊：读UTF-8修改版，用DataOutputStream写入的UTF字符编码就只能用DataInputStream读取相应的字符编码。
    //里面一个中文4个字节；而OutputStreamWriter写入的编码字符集UTF-8中一个中文3个字节；gbk是2个字节。
    readUtf()

}

private fun readUtf() {
    var dis: DataInputStream? = null
    try {
        dis = DataInputStream(FileInputStream("dos.txt"))
        println(dis.readUTF())
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (dis != null) {
            try {
                dis.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

private fun writeUtf() {
    var dos: DataOutputStream? = null
    try {
        dos = DataOutputStream(FileOutputStream("dos.txt"))
        dos.writeUTF("你好")
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (dos != null) {
            try {
                dos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

private fun read() {
    var dis: DataInputStream? = null
    try {
        dis = DataInputStream(FileInputStream("dos.txt"))
        //读取顺序不要错了，什么顺序写就什么顺序读
        println(dis.readBoolean())
        println(dis.readInt())
        println(dis.readDouble())
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (dis != null) {
            try {
                dis.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

private fun write() {

    var dos: DataOutputStream? = null

    try {
        dos = DataOutputStream(FileOutputStream("dos.txt"))
        dos.writeBoolean(true)
        dos.writeInt(123)
        dos.writeDouble(123.456)
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (dos != null) {
            try {
                dos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}