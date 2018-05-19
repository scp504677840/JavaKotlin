package generics.consumer

import generics.Consumer
import generics.entity.Food

class EveryBody : Consumer<Food> {

    override fun consumer(item: Food) {
        println("吃食物")
    }

}