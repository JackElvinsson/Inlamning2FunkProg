package adventofcode.d1_2022

import java.nio.file.Files
import java.nio.file.Paths

//TODO Lägga till uppgiftstexten


/* Inspirerad av flertal lösningar på reddit samt Todd Ginsbergs lösning https://todd.ginsberg.com/post/advent-of-code/2022/day1/

 * 1. Läser in filen och returnerar en sorterad(fallande) lista med talen i form av Int
 * 2. Delar upp strängen i en lista med strängar där varje sträng motsvarar en rad i filen
 * 3. Map() och sumOf() lägger ihop alla tal i varje sträng och returnerar en lista med dessa tal i form av Int
 * 4. Sorterar listan med talen i fallande ordning

 * Del 1. Plockar ut det första elementet i listan och returnerar det
 * Del 2. Plockar ut de 3 första elementen i listan och returnerar summan av dessa

 */

// Konstruktorn tar in en String i form av en fil, denna sträng används sedan i parseInput() för att skapa en lista med tal i fallande ordning
class Day012022NEW(input: String) {


    // Läser in data-strängen och returnerar en sorterad(fallande) lista med talen i form av Int
    private val calories = input
        // trimmar och delar upp strängen i en lista med strängar där varje sträng motsvarar en rad i filen
        .trim()
        .split("\r\n\r\n")
        // map() och sumOf() lägger ihop alla tal i varje sträng och returnerar en lista med dessa tal i form av Int
        .map { it.lines().sumOf(String::toInt) }
        // sorterar listan i fallande ordning
        .sortedDescending()

    // Plockar ut det första elementet i listan och returnerar det
    internal fun part1(): Int =
        calories.first()

    // Plockar ut de 3 första elementen i listan och returnerar summan av dessa
    internal fun part2(): Int =
        calories.take(3).sum()

}


fun main() {
    val inputFilePath = "src/main/resources/calorieData_d1_2022"
    val inputString = Files.readString(Paths.get(inputFilePath))
    val day01 = Day012022NEW(inputString)
    println("Part 1: ${day01.part1()}")
    println("Part 2: ${day01.part2()}")
}
