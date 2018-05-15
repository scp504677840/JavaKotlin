package part03

/**
 * 多线程之间通信，用同步解决发生问题的代码
 * 生产一个 消费一个
 * Kotlin中的每个类都继承自Any，
 * 但Any不声明wait（），notify（）和notifyAll（），
 * 这意味着这些方法不能在Kotlin类上调用。
 * 但是你仍然可以使用java.lang.Object的一个实例作为锁，并调用它的方法。
 */
fun main(args: Array<String>) {

    val res = Res3()
    //使用java.lang.Object的一个实例作为锁
    val lock = java.lang.Object()

    fun produce() {
        var flag = true
        while (true) {
            synchronized(lock) {
                if (res.flag) {
                    lock.wait()
                }
                if (flag) {
                    res.name = "jack"
                    res.sex = "nan"
                } else {
                    res.name = "莉莉"
                    res.sex = "女女女女女女"
                }
                res.flag = true
                flag = !flag
                lock.notify()
            }
        }
    }

    fun consume() {
        while (true) {
            synchronized(lock) {
                if (!res.flag) {
                    lock.wait()
                }
                println("${res.name} ... ${res.sex}")
                res.flag = false
                lock.notify()
            }
        }
    }

    Thread({
        produce()
    }).start()
    Thread({
        consume()
    }).start()

}

private data class Res3 constructor(var name: String = "init name",
                                    var sex: String = "init sex",
                                    var flag: Boolean = false)