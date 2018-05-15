package part03

/**
 * join
 * 当A线程执行到B线程的join方法时，就会释放执行权，进入冻结状态，等待A线程执行完。
 * 特殊情况：当A线程wait了，此时B线程当冻结状态就被清除了，B线程的冻结状态被强制清除，就会发生InterruptedException。
 * 这就是为什么join方法会抛出InterruptedException。
 * 为什么A线程wait，就要唤醒B线程？
 * 前提条件是程序中就两个线程，如果不唤醒B线程，那程序就一直在那等待，卡着不动，因为程序中的线程都wait了。
 */
fun main(args: Array<String>) {

    fun pl(){
        for (x in 0..10){
            println("${Thread.currentThread().name} ... $x")
        }
    }

    val thread1 = Thread({ pl() })
    val thread2 = Thread({ pl() })

    thread1.start()

    /*
    1.首先Thread.currentThread()是主线程。
    2.主线程执行到thread1.join()方法以后，主线程会释放执行权，进入冻结状态。
    3.thread1此时抢到执行权，主线程要等到thread1执行完才恢复过来。
     */
    thread1.join()

    thread2.start()

    pl()

}