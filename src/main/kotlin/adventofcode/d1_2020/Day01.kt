package adventofcode.d1_2020

import java.nio.file.Files
import java.nio.file.Paths

/*
 * --- Day 1: Report Repair ---
 * Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle input); apparently, something isn't quite adding up.
 * Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.
 * For example, suppose your expense report contained the following:
 *
 * 1721
 * 979
 * 366
 * 299
 * 675
 * 1456
 * In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
 * Find the two entries that sum to 2020; what do you get if you multiply them together?
 *
 * --- Part Two ---
 * The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left over from a past vacation.
 * They offer you a second one if you can find three numbers in your expense report that meet the same criteria.
 * Using the above example again, the three entries that sum to 2020 are 979, 366, and 675.
 * Multiplying them together produces the answer, 241861950.
 * In your expense report, what is the product of the three entries that sum to 2020?
 */

class Day012020(input: String) {

    private val entryData = parseInput(input)


    // part01 börjar med att iterera igenom listan och lägga till varje element i ett set (seen)
    // sedan itererar vi igenom listan igen och för varje element i listan (num) så tar vi 2020 - num
    // om complement finns i setet (used) så multipliceras num med complement och returneras
    // om inget element i listan uppfyller villkoret så returneras 0
    internal fun part1(): Int {
        val used = entryData.toMutableSet()
        for (num in entryData) {
            val complement = 2020 - num
            if (complement in used) {
                return num * complement
            }
        }
        return 0
    }

    // Precis som i part1 så itererar vi igenom listan ännu en gång, men den här gången med två for-loopar
    // för varje element i listan (num1) så itererar vi igenom listan igen (num2)
    // sedan tar vi 2020 - num1 - num2 och kollar om complement finns i listan
    // om complement finns i setet (used) så multipliceras num1, num2 och complement och returneras
    // annars fortsätter loopen
    // om inget element i listan uppfyller villkoret så returneras 0
    internal fun part2(): Int {
        val used = entryData.toMutableSet()
        for (num1 in entryData) {
            for (num2 in entryData) {
                val complement = 2020 - num1 - num2
                if (complement in used) {
                    return num1 * num2 * complement
                }
            }
        }
        return 0
    }

    // parseInput tar in en sträng och returnerar en lista med Int som är separerade av newlines
    // **SMIDIG** lines() delar upp strängen i en lista med strängar där varje element är separerat av newlines
    internal fun parseInput(input: String): List<Int> {
        return input.lines().map { it.toInt() }
    }
}

fun main() {
    val inputFilePath = "src/main/resources/expansesData_d1_2020"
    val inputString = Files.readString(Paths.get(inputFilePath))
    val day01 = Day012020(inputString)

    println("Part 1: ${day01.part1()}")
    println("Part 2: ${day01.part2()}")
}