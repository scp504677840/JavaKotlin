package part06

fun main(args: Array<String>) {
    val list = arrayListOf(11, 22, 33, 44, 55)

    /*val iterator = list.iterator()
    while (iterator.hasNext()) {
        val next = iterator.next()
        if (next % 2 == 0) {
            iterator.remove()
            continue
        }
        //println(next)
    }*/

    val listIterator = list.listIterator()
    while (listIterator.hasNext()) {
        val next = listIterator.next()
        if (next % 2 == 0) {
            //添加
            //listIterator.add(66)
            //修改
            listIterator.set(88)
            //删除
            //listIterator.remove()
            continue
        }
    }

    list.forEach { println(it) }
}