package adventofcode.d2_2022

import java.nio.file.Files
import java.nio.file.Paths

//TODO Lägga till uppgiftstexten och inspiration till lösningen

class Day02after(private val input: List<String>) {

    /*
     Inspirerad av lösningar på reddit och Todd Ginsberg's lösning: https://todd.ginsberg.com/post/advent-of-code/2022/day2/

     * Funktionen mapOf() används för att skapa en ny oföränderlig map med nyckel-värde-par för alla möjliga kombinationer och deras motsvarande poäng.
     * I detta fall är nycklarna strängar i formatet "A X", "A Y", "A Z", "B X", "B Y", "B Z", "C X", "C Y" och "C Z", som representerar alla möjliga kombinationer av de tre alternativen.
     * Värdena är motsvarande poäng, som beräknas genom att lägga till två värden för varje kombination
     */

    // Skapar en map med alla möjliga kombinationer av A, B och C mot X, Y och Z och lägger till respektive poäng för varje kombination
    // Det som händer när vi sedan anropar part1 eller part2 är att vi skickar in en sträng som motsvarar en kombination av A, B och C mot X, Y och Z
    // Exempel: "A X" eller "B Z"
    // Denna sträng används sedan som nyckel i mapen och returnerar då det motsvarande värdet, som är poängen för den kombinationen
    // Med hjälp av sumOf() kan vi sedan lägga till poängen för de två valen som spelaren gjort
    private val part1Scores: Map<String, Int> =
        mapOf(
            "A X" to 1 + 3,
            "A Y" to 2 + 6,
            "A Z" to 3 + 0,
            "B X" to 1 + 0,
            "B Y" to 2 + 3,
            "B Z" to 3 + 6,
            "C X" to 1 + 6,
            "C Y" to 2 + 0,
            "C Z" to 3 + 3,
        )

    // Samma som ovan fast med andra poäng enligt del 2
    private val part2Scores: Map<String, Int> =
        mapOf(
            "A X" to 3 + 0,
            "A Y" to 1 + 3,
            "A Z" to 2 + 6,
            "B X" to 1 + 0,
            "B Y" to 2 + 3,
            "B Z" to 3 + 6,
            "C X" to 2 + 0,
            "C Y" to 3 + 3,
            "C Z" to 1 + 6,
        )

    // Lägger ihop alla poäng för varje rad i inputen och returnerar summan
    fun part1(): Int =
        input.sumOf { part1Scores[it] ?: 0 }
    // Samma som ovan fast med andra poäng enligt del 2
    fun part2(): Int =
        input.sumOf { part2Scores[it] ?: 0 }
}

fun main() {
    val inputFilePath = "src/main/resources/rockPaperScissorsData_d2_2022"
    val inputString = Files.readString(Paths.get(inputFilePath))
    // Separerar inputen i en lista med en rad per element direkt i konstruktorn
    val day02 = Day02after(inputString.lines())

    // ${day02.solvePart1()} och ${day02.solvePart2()} är samma som att skriva day02.solvePart1().toString() och day02.solvePart2().toString()
    println("Part 1: ${day02.part1()}")
    println("Part 2: ${day02.part2()}")
}