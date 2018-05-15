package part03

/**
 * 多线程之间通信，用同步解决发生问题的代码
 */
fun main(args: Array<String>) {

    val res = Res2()

    val input = Input2(res)
    val output = Output2(res)

    Thread(input).start()
    Thread(output).start()

}

private data class Res2 constructor(var name: String = "init name", var sex: String = "init sex")

private class Input2(private val res: Res2) : Runnable {
    private var flag = true
    override fun run() {
        while (true) {
            synchronized(res) {
                if (flag) {
                    res.name = "jack"
                    res.sex = "nan"
                } else {
                    res.name = "莉莉"
                    res.sex = "女女女女女女"
                }
                flag = !flag
            }
        }
    }
}

private class Output2(private val res: Res2) : Runnable {
    override fun run() {
        while (true) {
            synchronized(res) {
                println("${res.name} ... ${res.sex}")
            }
        }
    }
}