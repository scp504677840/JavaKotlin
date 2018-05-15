package part02

fun main(args: Array<String>) {
    while (true) {
        Thread({
            println(Single.getInstance().hashCode())
        }).start()
    }
}

private class Single {

    private constructor()

    companion object {
        private var single: Single? = null

        fun getInstance(): Single {
            if (single == null) {
                synchronized(Single) {
                    if (single == null) {
                        Thread.sleep(10)
                        single = Single()
                    }
                }
            }
            return single!!
        }

        /*@Synchronized
        fun getInstance(): Single {
            if (single == null) {
                Thread.sleep(10)
                single = Single()
            }
            return single!!
        }*/
    }
}