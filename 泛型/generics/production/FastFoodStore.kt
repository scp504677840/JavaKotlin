package generics.production

import generics.Production
import generics.entity.FastFood

class FastFoodStore : Production<FastFood> {

    override fun produce(): FastFood {
        println("FastFoodStore：生产快餐")
        return FastFood()
    }

}