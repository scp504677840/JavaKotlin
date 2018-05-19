package generics.production

import generics.Production
import generics.entity.Food

class FoodStore : Production<Food> {

    override fun produce(): Food {
        println("FoodStore：生产食物")
        return Food()
    }

}