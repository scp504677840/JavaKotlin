package part05

fun main(args: Array<String>) {
    /*for (x in 0..3) {
        for (y in 0..x) {
            print("*")
        }
        println()
    }

    for (x in 0..3) {
        for (y in 0..3 - x) {
            print("*")
        }
        println()
    }*/

    val str1 = "znasdkhellowacd"
    val str2 = "adhelloas"
    println(getIndexLength(str1, str2))
}

fun getIndexLength(str1: String, str2: String): String {
    val min = str1.lastIndex < str2.lastIndex
    val shortStr: String = if (min) str1 else str2
    val longStr: String = if (!min) str1 else str2

    for (x in 0..shortStr.lastIndex) {
        var z = shortStr.lastIndex - x
        for (y in 0..x) {
            z++
            val substring = shortStr.substring(y, z)
            if (longStr.contains(substring)) return substring
        }
    }

    return ""
}
