package part02

fun main(args: Array<String>) {
    val cus = Cus3()
    val one = Thread(cus)
    val two = Thread(cus)
    one.start()
    two.start()
}

private class Bank3 constructor(private var sum: Int = 0) {
    private val o = Any()

    //同步方法
    @Synchronized
    fun add(n: Int) {
        sum += n
        Thread.sleep(10)
        println("sum=$sum")
    }

    //同步代码块
    /*fun add(n: Int) {
        synchronized(o){
            sum += n
            Thread.sleep(10)
            println("sum=$sum")
        }
    }*/
}

private class Cus3 : Runnable {
    private val bank = Bank3()
    override fun run() {
        for (x in 0..2) {
            bank.add(100)
        }
    }
}