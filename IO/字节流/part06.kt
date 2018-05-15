package part09

import java.io.InputStream

/**
 * 键盘录入
 */
fun main(args: Array<String>) {

    var `in`: InputStream? = null

    try {
        `in` = System.`in`

        val sb = StringBuilder()

        while (true) {

            val value = `in`.read()
            if (value == -1) break

            //换行，10就是\n
            if (value == 10) {
                val line = sb.toString()
                println(line)
                sb.delete(0, sb.length)

                //当遇到over时，跳出循环
                if (line == "over") break

                //跳过本次循环
                continue
            }

            sb.append(value.toChar())

        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (`in` != null) {
            try {
                `in`.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}