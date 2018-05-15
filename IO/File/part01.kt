package part10

import java.io.File
import java.io.FilenameFilter
import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {

    val file = File("/Users/scp/Documents/Workspace/Java/KJ")

    println(file)

    //canExecute
    //println("canExecute:${file.canExecute()}")
    //canRead
    //println("canRead:${file.canRead()}")
    //canWrite
    //println("canWrite:${file.canWrite()}")

    //compareTo​

    //createNewFile创建文件，当文件不存在时创建，存在时则不创建。
    //println("createNewFile:${file.createNewFile()}")

    //创建临时文件
    //createTempFile​
    //createTempFile​
    //println("createTempFile:${File.createTempFile("ttt",".txt")}")

    //delete删除文件
    //println("delete:${file.delete()}")
    //deleteOnExit在程序退出的时候删除文件
    //println("deleteOnExit:${file.deleteOnExit()}")

    //equals​

    //exists判断文件是否存在
    //println("exists:${file.exists()}")

    //getAbsoluteFile
    //结果/Users/scp/Documents/Workspace/Java/KJ/fos.txt
    //println("getAbsoluteFile:${file.absoluteFile}")
    //getAbsolutePath
    //结果/Users/scp/Documents/Workspace/Java/KJ/fos.txt
    //println("getAbsolutePath:${file.absolutePath}")
    //getCanonicalFile
    //结果/Users/scp/Documents/Workspace/Java/KJ/fos.txt
    //println("getCanonicalFile:${file.canonicalFile}")
    //getCanonicalPath
    //结果/Users/scp/Documents/Workspace/Java/KJ/fos.txt
    //println("getCanonicalPath:${file.canonicalPath}")

    //getName
    //结果getName:fos.txt
    //println("getName:${file.name}")
    //getParent
    //相对路径返回null
    //绝对路径返回父，例如：目录/Users/scp/Documents/Workspace/Java/KJ
    //println("getParent:${file.parent}")
    //getParentFile
    //相对路径返回null
    //绝对路径返回父目录，例如：结果/Users/scp/Documents/Workspace/Java/KJ
    //println("getParentFile:${file.parentFile}")
    //getPath
    //和你创建File对象时的路径一致，你创建时传入相对路径，那么返回的就是相对路径，你创建时传入绝对路径，那么返回的就是绝对路径。
    //println("getPath:${file.path}")

    //getFreeSpace
    //未分配大小
    //println("getFreeSpace:${file.freeSpace}")
    //getTotalSpace
    //总大小
    //println("getTotalSpace:${file.totalSpace}")
    //getUsableSpace
    //可用大小
    //println("getUsableSpace:${file.usableSpace}")

    //hashCode

    //isAbsolute是绝对路径吗
    //结果isAbsolute:false
    //println("isAbsolute:${file.isAbsolute}")
    //isDirectory是否为目录，记住判断前先判断这个文件是否存在
    //结果isDirectory:false
    //println("isDirectory:${file.isDirectory}")
    //isFile是否为文件，记住判断前先判断这个文件是否存在
    //结果isFile:true
    //println("isFile:${file.isFile}")
    //isHidden是否为隐藏文件
    //结果isHidden:false
    //println("isHidden:${file.isHidden}")

    //lastModified文件最后修改时间
    //val m = file.lastModified()
    //val date = Date(m)
    //val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    //println("lastModified:${sdf.format(date)}")
    //2018-05-06 02:45:20

    //length文件长度
    //println("length:${file.length()}")

    //list列出文件（包括目录，隐藏文件）的名字
    //list​
    //val list = file.list()
    //list.forEach { println(it) }
    //结果：abc.jpg
    //结果：demo.txt
    //结果：fileWriter.txt
    //过滤文件
    //val list = file.list { dir, name -> name.endsWith(".txt") }
    //list.forEach { println(it) }

    //listFiles列出文件（包括目录，隐藏文件）的绝对路径
    //listFiles​
    //listFiles​
    //val listFiles = file.listFiles()
    //listFiles.forEach { println(it) }
    //结果：/Users/scp/Documents/Workspace/Java/KJ/abc.jpg
    //结果：/Users/scp/Documents/Workspace/Java/KJ/demo.txt
    //结果：/Users/scp/Documents/Workspace/Java/KJ/fileWriter.txt
    //过滤文件
    //val listFiles = file.listFiles { dir, name -> name.endsWith(".txt") }
    //listFiles.forEach { println(it) }

    //listRoots列出可用的文件系统根目录。
    //val listRoots = File.listRoots()
    //listRoots.forEach { println(it) }
    //结果：/

    //mkdir创建目录，只有一层
    //println("mkdir:${file.mkdir()}")
    //mkdirs创建多层目录
    //println("mkdirs:${file.mkdirs()}")

    //renameTo​文件改名
    //println("renameTo:${file.renameTo(File("aa.txt"))}")

    //setExecutable​
    //setExecutable​
    //setLastModified​
    //setReadable​
    //setReadable​
    //setReadOnly
    //setWritable​
    //setWritable​

    //toPath将文件转为路径，如果文件最初为相对路径那么返回的就是相对路径，如果为绝对路径，那么就为绝对路径。
    //println("toPath:${file.toPath()}")

    //toString打印文件路径，如果文件最初为相对路径那么返回的就是相对路径，如果为绝对路径，那么就为绝对路径。
    //println("toString:${file.toString()}")

    //toURI将文件转为URI
    //直接打印URI就是文件的绝对路径
    //val uri = file.toURI()
    //println("toURI:${uri}")

}