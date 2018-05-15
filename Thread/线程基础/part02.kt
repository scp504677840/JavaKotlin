package part02

fun main(args: Array<String>) {
    /*val one = Part2("one")
    val two = Part2("two")
    val three = Part2("three")
    val four = Part2("four")
    one.start()
    two.start()
    three.start()
    four.start()*/

    val r = Run2()
    val one = Thread(r)
    val two = Thread(r)
    val three = Thread(r)
    val four = Thread(r)
    one.start()
    two.start()
    three.start()
    four.start()
}

private class Part2(name: String) : Thread(name) {
    private var ticket = 100
    override fun run() {
        while (true) {
            if (ticket > 0) {
                println("${currentThread().name} ... ${ticket--}")
            }
        }
    }
}

private class Run2 : Runnable {
    private var ticket = 1000
    private var o = Any()
    override fun run() {
        while (true) {
            synchronized(o){
                if (ticket > 0) {
                    Thread.sleep(10)
                    println("${Thread.currentThread().name} ... ${ticket--}")
                }
            }
        }
    }
}