fun main() {
    println("Введите слова через пробел:")
    val words = readLine()!!.split(" ").filter { it.isNotBlank() }

    val chains = WordChains(words)

    println("Цепочки:")
    chains.forEach { println(it.joinToString(" → ")) }
}

fun WordChains(words: List<String>): List<List<String>> {
    val result = mutableListOf<List<String>>()

    for (word in words) {
        val chain = mutableListOf(word)
        var currentWord = word

        while (true) {
            val lastChar = currentWord.last()
            val nextWord = words.find { it.first() == lastChar && it !in chain }

            if (nextWord != null) {
                chain.add(nextWord)
                currentWord = nextWord
                if (chain.size > 1) {
                    result.add(chain.toList())
                }
            } else {
                break
            }
        }
    }

    return result
}