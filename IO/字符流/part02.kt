package part08

import java.io.FileWriter

/**
 * 向已存在的文本文件追加字符
 */
fun main(args: Array<String>) {
    var fw: FileWriter? = null

    try {
        //千万要注意：中构造函数中，第二个参数append为true时，才不会覆盖已存在的文本文件，其余打开方式都会覆盖原有的文本文件。
        fw = FileWriter("fileWriter.txt", true)
        fw.write("hahaha")
        fw.write("ppqq")
        fw.append("我是追加的字符。")
        fw.appendln("我是FileWriter特有的追加字符方法，并且我可以中追加完毕后换行。")
        fw.appendln("我是FileWriter特有的追加字符方法，并且我可以中追加完毕后换行。")
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (fw != null) {
            try {
                fw.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
