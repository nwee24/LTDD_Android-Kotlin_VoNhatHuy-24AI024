package com.example.bai2

import kotlin.math.PI

fun main() {

    println("=== CLASSES ===")

    val squareCabin = SquareCabin(
        residents = 6,
        length = 5.0
    )

    val roundHut = RoundHut(
        residents = 3,
        radius = 3.0
    )

    println("Square cabin floor area: ${squareCabin.floorArea()}")
    println("Round hut floor area: ${roundHut.floorArea()}")


    with(squareCabin) {
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
    }

    println("\n=== LIST ===")

    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println("Size: ${numbers.size}")
    println("First element: ${numbers[0]}")
    println("Reversed: ${listOf("red", "blue", "green").reversed()}")

    val entrees = mutableListOf<String>()
    entrees.add("spaghetti")
    println(entrees)

    entrees[0] = "lasagna"
    println(entrees)

    entrees.remove("lasagna")
    println(entrees)
    println("\n=== LOOPS ===")

    val myList = listOf("A", "B", "C")

    for (element in myList) {
        println("For loop: $element")
    }

    var index = 0
    while (index < myList.size) {
        println("While loop: ${myList[index]}")
        index++
    }

    println("\n=== STRING ===")

    val name = "Android"
    println("Length: ${name.length}")

    val number = 10
    val groups = 5
    println("$number people")
    println("${number * groups} people")
    println("\n=== ASSIGNMENT OPERATORS ===")

    var a = 10
    val b = 5

    a += b
    println(a)

    a -= b
    println(a)

    a *= b
    println(a)

    a /= b
    println(a)

    println("\n=== VARARG ===")

    addToppings("Cheese", "Olives", "Mushrooms")
}

abstract class Dwelling(private val residents: Int) {

    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    abstract fun floorArea(): Double
}

open class RoundHut(
    residents: Int,
    private val radius: Double
) : Dwelling(residents) {

    override val buildingMaterial: String = "Straw"
    override val capacity: Int = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }
}

class SquareCabin(
    residents: Int,
    private val length: Double
) : Dwelling(residents) {

    override val buildingMaterial: String = "Wood"
    override val capacity: Int = 6

    override fun floorArea(): Double {
        return length * length
    }
}


fun addToppings(vararg toppings: String) {
    for (topping in toppings) {
        println("Topping: $topping")
    }
}
