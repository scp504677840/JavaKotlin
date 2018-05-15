package part03

/**
 * 释放当前执行权
 * Thread.yield()
 */
fun main(args: Array<String>) {

    fun pl(){
        for (x in 0..10){
            println("${Thread.currentThread()} ... $x")
            //释放当前执行权
            Thread.yield()
        }
    }

    val thread1 = Thread({ pl() })
    val thread2 = Thread({ pl() })

    thread1.start()
    thread2.start()

    pl()

}