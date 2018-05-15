package part07

fun main(args: Array<String>) {

    val hashMap = HashMap<String, Int>()
    println(hashMap.put("a", 1))//null
    println(hashMap.put("a", 2))//1

    hashMap.keys.forEach { println(it) }
    hashMap.keys.forEach { println(hashMap[it]) }

    hashMap.entries.forEach { println("key:${it.key}---value:${it.value}") }

}