package part08

import java.io.FileReader

fun main(args: Array<String>) {
    var fr: FileReader? = null

    try {
        fr = FileReader("fileWriter.txt")

        val cbuf = CharArray(3)
        var length = fr.read(cbuf)
        println("length:$length,cbuf:${String(cbuf)}")
        //length:3,cbuf:abc

        length = fr.read(cbuf)
        println("length:$length,cbuf:${String(cbuf)}")
        //length:3,cbuf:def

        length = fr.read(cbuf)
        println("length:$length,cbuf:${String(cbuf)}")
        //length:1,cbuf:gef
        // 注意：这里出现了gef，说明一下这是为什么：
        // 1.val cbuf = CharArray(3)最开始创建的时候，里面都是空字符。
        // 2.当我们第一次执行fr.read(cbuf)方法时，cbuf里面就装了abc三个字符，所以打印就是abc。
        // 3.我们还记得上一次cbuf字符数组里面装的是abc没错吧，接下来再次执行fr.read(cbuf)方法，
        // 里面就将abc的位置分别装了新读取的def，于是呢，cbuf字符数组里面此时此刻装的def，所以打印的是def。
        // 4.我们知道前一次cbuf字符数组里面装的是def，也就是cbuf[0] = d,cbuf[1] = e,cbuf[2] = f；
        // 我们在读取之前先来看看文本文件里面还剩下几个字符：g；（原文件文件中的字符为：abcdefg，其中abcdef已经读过了，只剩下g没有读）
        // 好，接下来我们再执行一次fr.read(cbuf)方法，此时我们只读取到了g一个字符，然后将其依次存入cbuf字符数组中，于是cbuf[0] = g；
        // 此时，我们来观察一下cbuf字符数组：cbuf[0] = g,cbuf[1] = e,cbuf[2] = f；故，打印cbuf字符数组为：gef。

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