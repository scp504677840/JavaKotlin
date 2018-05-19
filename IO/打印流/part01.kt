package io

import java.io.*

fun main(args: Array<String>) {

    var br: BufferedReader? = null
    var pw: PrintWriter? = null

    try {
        br = BufferedReader(InputStreamReader(System.`in`))

        //不带缓冲区
        //pw = PrintWriter(System.out,true)

        //带缓冲区
        pw = PrintWriter(BufferedOutputStream(System.out),true)

        while (true) {
            val line = br.readLine() ?: break
            if (line == "end") break
            //手动刷新
            //pw.write(line.toUpperCase())
            //pw.flush()

            //自动刷新，前提是开启pw = PrintWriter(System.out,true)
            pw.println(line.toUpperCase())
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
        if (pw != null) {
            try {
                pw.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}