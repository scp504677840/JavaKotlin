package generics.consumer

import generics.Consumer
import generics.entity.Burger

class American : Consumer<Burger> {

    override fun consumer(item: Burger) {
        println("吃汉堡")
    }

}