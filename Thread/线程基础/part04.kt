package part02

fun main(args: Array<String>) {
    val r = Run4()
    val one = Thread(r)
    val two = Thread(r)
    one.start()
    Thread.sleep(10)
    r.flag = false
    two.start()
}

private class Run4 : Runnable {
    private var ticket: Int = 100
    var flag = true
    //private val o = Any()

    override fun run() {
        if (flag) {
            while (true) {
                synchronized(this){
                    if (ticket > 0) {
                        Thread.sleep(10)
                        println("${Thread.currentThread().name} ... ${ticket--}")
                    }
                }
            }
        } else {
            show()
        }
    }

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