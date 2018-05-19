package generics

/**
 * 生产者（协变）
 * 你只能是我或者是我的子类
 */
interface Production<out T> {

    fun produce(): T

}