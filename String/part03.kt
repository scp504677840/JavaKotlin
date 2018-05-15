package part05

fun main(args: Array<String>) {
    var str = "abcdefg"
    str = reverse(str)
    println(str)
}

fun reverse(str: String): String {
    val srcCharArray = str.toCharArray()
    var temp: Char?
    for (x in 0..srcCharArray.lastIndex.div(2)) {
        temp = srcCharArray[x]
        val last = srcCharArray.lastIndex - x
        srcCharArray[x] = srcCharArray[last]
        srcCharArray[last] = temp
        println(String(srcCharArray))
    }
    return String(srcCharArray)
}
