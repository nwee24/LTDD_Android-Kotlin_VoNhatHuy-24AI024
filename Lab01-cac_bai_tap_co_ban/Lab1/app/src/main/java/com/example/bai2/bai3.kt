fun main() {

    println("=== SET ===")

    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    val setOfNumbers = numbers.toSet()
    println("Set from list: $setOfNumbers")

    val set1 = setOf(1, 2, 3)
    val set2 = mutableSetOf(3, 4, 5)

    println("Intersect: ${set1.intersect(set2)}") // [3]
    println("Union: ${set1.union(set2)}")         // [1,2,3,4,5]
    println("\n=== MAP ===")

    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )

    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51

    peopleAges.forEach {
        print("${it.key} is ${it.value}, ")
    }
    println()


    println(
        peopleAges.map { "${it.key} is ${it.value}" }
            .joinToString(", ")
    )

    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println("Filtered names: $filteredNames")


    println("\n=== COLLECTION OPERATIONS ===")

    val words = listOf("about", "acute", "balloon", "best", "brief", "class")
    val filteredWords = words
        .filter { it.startsWith("b", ignoreCase = true) }
        .shuffled()
        .take(2)
        .sorted()

    println("Filtered words: $filteredWords")


    println("\n=== SCOPE FUNCTIONS ===")

    val arguments: Map<String, String>? = mapOf("LETTER" to "A")
    var letterId = ""

    arguments?.let {
        letterId = it["LETTER"].toString()
    }
    println("Letter ID (let): $letterId")

    val binding = StringBuilder()
    binding.apply {
        append("Hello ")
        append("Kotlin")
    }
    println("Apply result: $binding")

    println("\n=== BACKING PROPERTY ===")

    val game = Game()
    println("Current word: ${game.currentScrambledWord}")


    println("\n=== SAFE CALL ===")

    val intentExtras: Map<String, String>? = null
    val safeLetter = intentExtras?.get("letter").toString()
    println("Safe call result: $safeLetter")


    println("\n=== LAMBDA ===")

    val triple: (Int) -> Int = { a -> a * 3 }
    println("Triple 5 = ${triple(5)}")

    println("\n=== COMPANION OBJECT ===")

    println("LETTER constant: ${DetailActivity.LETTER}")


    println("\n=== LATEINIT ===")

    val wordManager = WordManager()
    wordManager.initWord()
    println("Current word: ${wordManager.currentWord}")


    println("\n=== ELVIS OPERATOR ===")

    var quantity: Int? = null
    println(quantity ?: 0)

    quantity = 4
    println(quantity ?: 0)
}


class Game {
    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord
}

class DetailActivity {
    companion object {
        const val LETTER = "letter"
    }
}

class WordManager {
    lateinit var currentWord: String

    fun initWord() {
        currentWord = "Kotlin"
    }
}
