package part03

/**
 * 守护线程
 */
fun main(args: Array<String>) {

    fun pl(){
        while (true){
            println("${Thread.currentThread().name} ... run")
        }
    }

    val thread1 = Thread({ pl() })
    val thread2 = Thread({ pl() })

    /*
    1.在线程执行前，将线程设置为守护线程：thread.isDaemon = true
    2.如果一个java程序中都是守护线程时，jvm将结束程序的运行。
     */
    thread1.isDaemon = true
    thread2.isDaemon = true

    thread1.start()
    thread2.start()

    for (x in 0..600000) {
        println("${Thread.currentThread().name} ... main ... $x")
    }

    println("${Thread.currentThread().name} ... main ... run")

}