package part09

import java.io.FileOutputStream

/**
 * FileOutputStream
 */
fun main(args: Array<String>) {

    var fos: FileOutputStream? = null

    try {
        fos = FileOutputStream("fos.txt")

        fos.write("aabbcc".toByteArray())

        //FileOutputStream是不需要刷新的。

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (fos != null) {
            try {
                fos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}