package part03

/**
 * 线程优先级
 * thread.priority
 */
fun main(args: Array<String>) {

    fun pl(){
        for (x in 0..10){
            println("${Thread.currentThread()} ... $x")
        }
    }

    val thread1 = Thread({ pl() })
    val thread2 = Thread({ pl() })

    thread1.priority = Thread.MIN_PRIORITY
    thread2.priority = Thread.MAX_PRIORITY

    thread1.start()
    thread2.start()

    pl()

}