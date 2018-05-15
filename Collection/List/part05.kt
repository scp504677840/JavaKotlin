package part06

fun main(args: Array<String>) {

    val hashSet = HashSet<Person>()

    hashSet.add(Person("aa", 11))
    hashSet.add(Person("aa", 11))
    //hashSet.add(Person("cc",33))
    //hashSet.add(Person("dd",44))
    //hashSet.add(Person("ee",55))

    val iterator = hashSet.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

}

private data class Person constructor(var name: String, var age: Int) {

    override fun hashCode(): Int {
        println("hashCode:$name--$age")
        return 6
        //return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        other as Person
        println("equals:${other.name}--${other.age}")
        return name == other.name && age == other.age
        //return super.equals(other)
    }

}