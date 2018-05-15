package part10

import java.io.File

/**
 * 递归打印文件目录下所有文件（包括子目录下的文件）
 */
fun main(args: Array<String>) {

    showFile(File("/Users/scp/Documents/Workspace/Java/KJ"))

}

private fun showFile(dir: File) {
    if (!dir.isDirectory) return
    val listFiles = dir.listFiles()
    listFiles.forEach {
        if (it.isDirectory) {
            showFile(it)
        }
        println(it)
    }
}