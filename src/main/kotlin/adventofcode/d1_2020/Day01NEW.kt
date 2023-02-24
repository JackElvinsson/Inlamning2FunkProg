package adventofcode.d1_2020


import java.nio.file.Files
import java.nio.file.Paths


   /* Inspirationskälla: https://blog.jetbrains.com/kotlin/2021/07/advent-of-code-in-idiomatic-kotlin/
    * Användning av lambda-funktioner och flatMap för att iterera igenom listan
    * Den gamla parseInput-funktionen är inte längre nödvändig eftersom det går att parsa direkt vid uppskapandet av entriyData
    */

class Day012020NEW(input: String) {

    // entryData tar in en sträng och returnerar en lista med Int's som är separerade av newlines
    // Detta går även att göra redan vid uppskpandet av Day012020NEW i main
    private val entryData = input.lines().map { it.toInt() }

    // part1 och part2 använder flatMap för att iterera igenom listan och jämföra varje element med alla andra element
    // om summan av de två elementen är 2020 multipliceras de två elementen och returneras
    // flatMap används för att kunna iterera igenom listan flera gånger
    // mapNotNull används för att kunna returnera null om villkoret inte uppfylls
    // first() används för att returnera det första elementet i listan som uppfyller villkoret
    internal fun part1() =
        entryData.flatMap { a -> entryData.mapNotNull { b -> if (a + b == 2020) a * b else null } }.first()

    // part2 fungerar ungefär som part1, men med en tredje loop
    // om summan av de tre elementen är 2020 multipliceras de tre elementen och returneras
    // first() används återigen för att returnera det första elementet i listan som uppfyller villkoret
    internal fun part2() =
        entryData.flatMap { a -> entryData.flatMap { b -> entryData.mapNotNull { c -> if (a + b + c == 2020) a * b * c else null } } }.first()
}

fun main() {
    val inputFilePath = "src/main/resources/expansesData_d1_2020"
    val inputString = Files.readString(Paths.get(inputFilePath))
    val day01 = Day012020NEW(inputString)

    println("Part 1: ${day01.part1()}")
    println("Part 2: ${day01.part2()}")
}