package part03

import java.util.concurrent.locks.ReentrantLock

/**
 * 多线程之间通信，用同步解决发生问题的代码
 * 生产一个 消费一个
 * Kotlin中的每个类都继承自Any，
 * 但Any不声明wait（），notify（）和notifyAll（），
 * 这意味着这些方法不能在Kotlin类上调用。
 * 但是你仍然可以使用java.lang.Object的一个实例作为锁，并调用它的方法。
 *
 * JDK1.5 Lock
 */
fun main(args: Array<String>) {

    val res = Res5()
    //JDK1.5 Lock
    val lock = ReentrantLock()

    //生产者等待唤醒机制
    val produceCondition = lock.newCondition()
    //消费者等待唤醒机制
    val consumeCondition = lock.newCondition()

    fun produce() {
        var flag = true
        while (true) {
            //锁
            lock.lock()
            try {
                while (res.flag) {
                    //生产者等待
                    produceCondition.await()
                }
                if (flag) {
                    res.name = "jack"
                    res.sex = "nan"
                } else {
                    res.name = "莉莉"
                    res.sex = "女女女女女女"
                }
                println("${Thread.currentThread().name} --- ${res.name} --- ${res.sex}")
                res.flag = true
                flag = !flag
                //唤醒消费者
                consumeCondition.signal()
            } finally {
                //释放锁
                lock.unlock()
            }
        }
    }

    fun consume() {
        while (true) {
            //锁
            lock.lock()
            try {
                while (!res.flag) {
                    //消费者等待
                    consumeCondition.await()
                }
                println("${Thread.currentThread().name} ...... ${res.name} ...... ${res.sex}")
                res.flag = false
                //唤醒生产者
                produceCondition.signal()
            } finally {
                //释放锁
                lock.unlock()
            }
        }
    }

    Thread({
        produce()
    }).start()
    Thread({
        produce()
    }).start()
    Thread({
        consume()
    }).start()
    Thread({
        consume()
    }).start()

}

private data class Res5 constructor(var name: String = "init name",
                                    var sex: String = "init sex",
                                    var flag: Boolean = false)