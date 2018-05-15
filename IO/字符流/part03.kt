package part08

import java.io.FileReader

fun main(args: Array<String>) {

    var fr: FileReader? = null

    try {
        fr = FileReader("fileWriter.txt")

        //read方法一次读一个字符，自动往下读。把文件读完最后会返回-1。
        //println(fr.read().toChar())//我
        //println(fr.read().toChar())//是
        //println(fr.read())//-1

        //遍历读取
        while (true) {
            val ch = fr.read()
            if (ch == -1) break
            print(ch.toChar())
        }

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (fr != null) {
            try {
                fr.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}