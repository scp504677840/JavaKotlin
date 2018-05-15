package part03

import java.util.concurrent.locks.ReentrantLock

/**
 * 中断线程
 *
 * interrupt清除线程的冻结状态，使线程进入可执行状态（注意不一定就是运行状态，还有一种可执行状态）。
 */
fun main(args: Array<String>) {

    var flag = true

    val lock = ReentrantLock()

    val condition = lock.newCondition()

    fun pl() {
        while (flag) {
            lock.lock()
            try {
                condition.await()
                println("${Thread.currentThread().name} ... run")
            } catch (e: Exception) {
                println("${Thread.currentThread().name} ... interrupt")
            } finally {
                lock.unlock()
            }
        }
    }

    val thread = Thread({ pl() })
    thread.start()

    for (x in 0..600000) {
        if (x == 500000) {
            flag = false
            thread.interrupt()
        }
    }

    println("${Thread.currentThread().name} ... main ... run")

}