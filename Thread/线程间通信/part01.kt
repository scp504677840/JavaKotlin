package part03

/**
 * 多线程之间通信，未同步会发生问题
 */
fun main(args: Array<String>) {

    val res = Res1()

    val input = Input1(res)
    val output = Output1(res)

    Thread(input).start()
    Thread(output).start()

}

private data class Res1 constructor(var name: String = "init name", var sex: String = "init sex")

private class Input1(private val res: Res1) : Runnable {
    private var flag = true
    override fun run() {
        while (true) {
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

private class Output1(private val res: Res1) : Runnable {
    override fun run() {
        while (true) {
            println("${res.name} ... ${res.sex}")
        }
    }
}