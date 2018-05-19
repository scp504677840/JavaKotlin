package io

import java.io.*

/**
 * Serializable
 * 序列化与反序列化
 */
fun main(args: Array<String>) {
    //存储
    //outObj()

    //读取
    readObj()
}

fun outObj() {

    var oos: ObjectOutputStream? = null

    try {
        oos = ObjectOutputStream(FileOutputStream("obj.txt"))
        oos.writeObject(Student("tom", 26))
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (oos != null) {
            try {
                oos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}

fun readObj() {

    var ois: ObjectInputStream? = null

    try {
        ois = ObjectInputStream(FileInputStream("obj.txt"))
        val student = ois.readObject()
        if (student is Student) {
            println(student)
        }

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        if (ois != null) {
            try {
                ois.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}

/**
 * 注意：
 * 1.当不希望字段被序列化时，请将字段用@kotlin.jvm.Transient注解（java版请在字段前写上 transient 修饰符）
 * 2.建议自定义serialVersionUID
 * 3.serialVersionUID是由类的构成计算得出的，所以当使用默认serialVersionUID时，只要类中有改变，那么serialVersionUID就会改变；而自定义serialVersionUID则不受影响。
 */
private data class Student constructor(var name: String,@kotlin.jvm.Transient var age: Int) : Serializable {

    companion object {
        const val serialVersionUID: Long = 42L
    }

    override fun toString(): String {
        return "Student(name='$name', age=$age)"
    }

}