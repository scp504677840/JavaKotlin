package part06

import java.util.TreeSet

fun main(args: Array<String>) {

    /*val treeSet = TreeSet<String>()

    treeSet.add("adbbcc")
    treeSet.add("abbabc")
    treeSet.add("acbcc")
    treeSet.add("abbc")
    treeSet.add("abcc")

    val iterator = treeSet.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }*/

    /*
    //元素自身具备比较性，实现Comparable接口即可。
    val treeSet = TreeSet<Student>()
    treeSet.add(Student("aa", 11))
    treeSet.add(Student("bb", 22))
    treeSet.add(Student("cc", 8))
    treeSet.add(Student("dd", 6))
    treeSet.add(Student("ee", 6))

    val iterator = treeSet.iterator()
    while (iterator.hasNext()) {
        val student = iterator.next()
        println("student:${student.name}--${student.age}")
    }*/


    //当元素不具备比较性，我们可以传入自定义比较器
    val treeSet = TreeSet<Student>(MyCompare())
    treeSet.add(Student("aa", 11))
    treeSet.add(Student("bb", 22))
    treeSet.add(Student("cc", 8))
    treeSet.add(Student("dd", 6))
    treeSet.add(Student("ee", 6))

    val iterator = treeSet.iterator()
    while (iterator.hasNext()) {
        val student = iterator.next()
        println("student:${student.name}--${student.age}")
    }

}

/**
 * 实现Comparable接口，实现比较方法
 */
private data class Student constructor(var name: String, var age: Int) : Comparable<Student> {
    override fun compareTo(other: Student): Int {
        if (age > other.age) return 1
        //注意：比较了主要条件以后，需要比较次要条件。
        if (age == other.age) {
            return name.compareTo(other.name)
        }
        return -1
    }
}

/**
 * 自定义比较器（推荐这种比较形式）
 */
private class MyCompare : Comparator<Student> {
    override fun compare(o1: Student, o2: Student): Int {
        val compareTo = o1.age.compareTo(o2.age)
        if (compareTo == 0) {
            return o1.name.compareTo(o2.name)
        }
        return compareTo
    }
}