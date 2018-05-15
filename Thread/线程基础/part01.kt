package part02

fun main(args: Array<String>) {
    val part1 = Part1("one")
    val part2 = Part1("two")
    part1.start()
    part2.start()

    for (x in 0..100)
        println("main run ... $x")
}

private class Part1(name:String) : Thread(name) {
    override fun run() {
        for (x in 0..100)
            println("${this.name} run ... $x")
    }
}