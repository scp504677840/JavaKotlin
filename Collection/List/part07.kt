package part06


/**
 * 泛型
 *
 * 1.静态方法不可以访问定义在类上的泛型
 * 2.静态方法如果需要定义泛型，则可以定义在静态方法上。
 */
fun main(args: Array<String>) {
    /*val tool = Tool<String>()
    tool.setObject("aaa")
    println(tool.getObject())*/

    val workers = ArrayList<Worker>()
    workers.add(Worker("w1", 11))
    workers.add(Worker("w2", 22))
    workers.add(Worker("w3", 33))

    val employees = ArrayList<Employee>()
    employees.add(Employee("e1", 1))
    employees.add(Employee("e2", 2))
    employees.add(Employee("e3", 3))

    //out Worker 本类及其子类
    //in Worker 本类及其父类
    printWorker(workers)
}

fun printColl(al: ArrayList<*>) {
    val it = al.iterator()
    while (it.hasNext()) {
        println(it.next().toString())
    }
}

fun printWorker(al: ArrayList<in Employee>) {
    val it = al.iterator()
    while (it.hasNext()) {
        println(it.next())
    }
}

private class Tool<T> {

    private var t: T? = null

    fun setObject(t: T) {
        this.t = t
    }

    fun getObject(): T? {
        return t
    }

    fun <T> pl(t: T) {
        println(t)
    }

}

private class Utils {
    fun <T> pl(t: T) {
        println(t)
    }
}

open class Worker constructor(open var name: String, open var age: Int) {}
class Employee(override var name: String, override var age: Int) : Worker(name, age) {}