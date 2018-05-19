package generics.production

import generics.Production
import generics.entity.Burger

class BurgerStore : Production<Burger> {

    override fun produce(): Burger {
        println("BurgerStore：生产汉堡")
        return Burger()
    }

}