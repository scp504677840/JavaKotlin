package part08

import java.io.FileWriter

/*
Writer	append​(char c)
将指定的字符附加到此作者。
Writer	append​(CharSequence csq)
将指定的字符序列追加到此作者。
Writer	append​(CharSequence csq, int start, int end)
将指定字符序列的子序列附加到此作者。
abstract void	close()
关闭小溪，首先冲洗它。
abstract void	flush()
刷新流。
void	write​(char[] cbuf)
写入一个字符数组。
abstract void	write​(char[] cbuf, int off, int len)
写入一个字符数组的一部分。
void	write​(int c)
写一个字符。
void	write​(String str)
写入一个字符串。
void	write​(String str, int off, int len)
写入一部分字符串。
 */
fun main(args: Array<String>) {

    var fw: FileWriter? = null

    try {
        //1.创建一个FileWriter对象，创建文件，如果文件已存在，则覆盖。
        fw = FileWriter("fileWriter.txt")

        //2.调用write方法，将字符串写入流中。
        fw.write("aabbcc")
        //3.刷新该流缓冲中的数据，将数据写入目的文件中。
        fw.flush()

        fw.write("ccddee")
        fw.flush()

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (fw != null) {
            try {
                //4.关闭流
                fw.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}