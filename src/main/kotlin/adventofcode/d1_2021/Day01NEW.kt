package adventofcode.d1_2021

import java.nio.file.Files
import java.nio.file.Paths

/*
 Inspiration från https://todd.ginsberg.com/post/advent-of-code/2021/day1/
 */


class Day012022NEW(private val input: List<Int>) {

    // Använder zipWithNext för att jämföra varje element med nästa element i listan
    // om det första elementet är mindre än det andra så returneras true och count räknar upp
    // zipWithNext() returnerar en lista med par av elementen i listan
    // count() returnerar antalet true-värden. Dessa motsvarar antalet gånger som det första elementet är mindre än det andra
    internal fun part1(): Int = input.zipWithNext().count { it.first < it.second }

    // Använder windowed för att skapa en lista med 3 element i taget
    // windowed(3, 1) skapar en lista med 3 element i taget där det första elementet i varje lista är det första elementet i den föregående listan
    // it.sum() summerar alla element i listan och returnerar summan
    // zipWithNext() returnerar en lista med par av elementen i listan
    // count() returnerar antalet true-värden. Dessa motsvarar antalet gånger som det första elementet är mindre än det andra
    internal fun part2(): Int = input.windowed(3, 1) { it.sum() }.zipWithNext().count { it.first < it.second }
}

fun main() {
    val inputFilePath = "src/main/resources/sonarSweepData_d1_2021"
    val inputString = Files.readString(Paths.get(inputFilePath))
    // Separerar inputen i en lista med strängar och returnerar en lista med integers direkt istället för att göra det i parseInput()
    val day01  = Day012022NEW(inputString.lines().map { it.toInt() })

    println("Part 1: ${day01.part1()}")
    println("Part 2: ${day01.part2()}")

}