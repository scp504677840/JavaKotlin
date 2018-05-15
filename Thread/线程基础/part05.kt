package part02

fun main(args: Array<String>) {
    val r = Run5()
    val one = Thread(r)
    val two = Thread(r)
    one.start()
    Thread.sleep(10)
    r.flag = false
    two.start()
}

private class Run5 : Runnable {

    var flag = true
    //private val o = Any()

    override fun run() {
        if (flag) {
            while (true) {
                //kotlin静态同步函数的同步锁是类对象
                //java静态同步函数的同步锁是类的字节码对象，也就是类.class
                //在kotlin中，不应该写Run5::class或Run5::class.java也不是Run5.javaClass，而是Run5
                //kotlin静态同步函数的同步锁写法不一样。
                synchronized(Run5){
                    if (ticket > 0) {
                        Thread.sleep(10)
                        println("${Thread.currentThread().name} ... ${ticket--}")
                    }
                }
                /*synchronized(this){
                    if (ticket > 0) {
                        Thread.sleep(10)
                        println("${Thread.currentThread().name} ... ${ticket--}")
                    }
                }*/
            }
        } else {
            show()
        }
    }

    companion object {
        private var ticket: Int = 100

        @Synchronized
        fun show() {
            while (true) {
                if (ticket > 0) {
                    Thread.sleep(10)
                    println("${Thread.currentThread().name} ...... ${ticket--}")
                }
            }
        }
    }
}