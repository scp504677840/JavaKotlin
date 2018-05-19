package generics

import generics.consumer.American
import generics.consumer.EveryBody
import generics.consumer.ModernPeople
import generics.entity.Burger
import generics.entity.Food
import generics.production.BurgerStore
import generics.production.FastFoodStore
import generics.production.FoodStore

/**
 * 协变
 * Collection<? extends String>
 * 具有扩展边界（上限）的通配符使得类型协变
 * 你只能是String或是String的子类
 * out
 *
 * 逆变
 * List<? super String>
 * 具有扩展边界（下限）的通配符使得类型逆变
 * 你只能是String或是String的父类
 * in
 *
 * PECS法则
 * PECS法则：生产者（Producer）使用extends，消费者（Consumer）使用super
 * 1、生产者
 *  如果你需要一个提供E类型元素的集合，使用泛型通配符<? extends E>。它好比一个生产者，可以提供数据。
 * 2、消费者
 *  如果你需要一个只能装入E类型元素的集合，使用泛型通配符<? super E>。它好比一个消费者，可以消费你提供的数据。
 * 3、既是生产者也是消费者
 *  既要存储又要读取，那就别使用泛型通配符。
 * PECS例子
 * JDK集合操作帮助类Collections中的例子
 * public static <T> void copy(List<? super T> dest, List<? extends T> src) {
 *     int srcSize = src.size();
 *     if (srcSize > dest.size())
 *         throw new IndexOutOfBoundsException("Source does not fit in dest");
 *
 *     if (srcSize < COPY_THRESHOLD ||
 *         (src instanceof RandomAccess && dest instanceof RandomAccess)) {
 *         for (int i=0; i<srcSize; i++)
 *             dest.set(i, src.get(i));
 *     } else {
 *         ListIterator<? super T> di=dest.listIterator();
 *         ListIterator<? extends T> si=src.listIterator();
 *         for (int i=0; i<srcSize; i++) {
 *             di.next();
 *             di.set(si.next());
 *         }
 *     }
 * }
 */
fun main(args: Array<String>) {

    //一般来说，要创建这样一个类的实例，我们需要提供类型参数：
    val box1 = Box<Int>(1)

    //但是，如果可以从构造函数参数或其他方式推断参数，则可以允许省略类型参数：
    val box2 = Box(2)

    //生产者示例
    //下面代码都是正确的，简述：
    //1.XXXStore是Production的子类
    //2.XXXStore实现的方法（produce）返回值是Food的子类
    //很显然，汉堡商店属于是快餐商店，当然也属于食品商店。
    //因此，对于 out 泛型，我们能够将使用子类泛型的对象赋值给使用父类泛型的对象。
    val production1: Production<Food> = FoodStore()
    val production2: Production<Food> = FastFoodStore()
    val production3: Production<Food> = BurgerStore()
    //而如果像下面这样反过来使用子类 - Burger 泛型，就会出现错误，因为快餐（fastfood）和食品（food）商店不仅仅提供汉堡（burger）。
    //val production4: Production<Burger> = FoodStore()//错误
    //val production5: Production<Burger> = FastFoodStore()//错误
    val production6: Production<Burger> = BurgerStore()

    //消费者示例
    //下面代码都是正确的，简述：
    //1.EveryBody、ModernPeople、American都是Consumer的子类
    //2.EveryBody、ModernPeople、American都实现了consumer方法，并且参数是Burger类型或是Burger的父类
    //很显然这里美国的汉堡的消费者既是现代人，更是人类。
    //因此，对于 in 泛型，我们可以将使用父类泛型的对象赋值给使用子类泛型的对象。
    val consumer1: Consumer<Burger> = EveryBody()
    val consumer2: Consumer<Burger> = ModernPeople()
    val consumer3: Consumer<Burger> = American()
    //同样，如果这里反过来使用父类 - Food 泛型，就会报错：
    val consumer4: Consumer<Food> = EveryBody()
    //val consumer5: Consumer<Food> = ModernPeople()//错误
    //val consumer6: Consumer<Food> = American()//错误

    //根据以上的内容，我们还可以这样来理解什么时候用 in 和 out：
    //父类泛型对象可以赋值给子类泛型对象，用 in；
    //子类泛型对象可以赋值给父类泛型对象，用 out。

}