package generics.consumer

import generics.Consumer
import generics.entity.FastFood

class ModernPeople : Consumer<FastFood> {

    override fun consumer(item: FastFood) {
        println("吃快餐")
    }

}