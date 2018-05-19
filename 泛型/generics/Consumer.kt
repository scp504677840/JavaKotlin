package generics

/**
 * 消费者（逆变）
 * 你只能是我或者是我的父类
 */
interface Consumer<in T> {

    fun consumer(item: T)

}