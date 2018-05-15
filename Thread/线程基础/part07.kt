package part02

fun main(args: Array<String>) {
    Thread(Lock7(true)).start()
    Thread(Lock7(false)).start()
}

private class Lock7(private val flag: Boolean) : Runnable {
    override fun run() {
        if (flag) {
            synchronized(lockA) {
                println("if lockA")
                synchronized(lockB) {
                    println("if lockB")
                }
            }
        } else {
            synchronized(lockB){
                println("else lockB")
                synchronized(lockA){
                    println("else lockA")
                }
            }
        }
    }

    companion object {
        val lockA = Any()
        val lockB = Any()
    }
}