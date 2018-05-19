package generics

/**
 * 既是生产者也是消费者（不变）
 * 如果既将泛型作为函数参数，又将泛型作为函数的输出，那就既不用in也不用out。
 */
interface ProductionConsumer<T> {

    fun produce(): T

    fun consumer(item: T)

}