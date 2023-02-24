package AoC_TEST.d1_2020

import adventofcode.d1_2020.Day012020
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day012020Test {

    class Day012020Test {

        @Test
        // Testar om part1() returnerar rätt värde med en lista med två tal som adderar till 2020
        fun testPart1_ReturnsCorrectValue_WithTwoEntries(){
            val day01 = Day012020("1721\n979\n366\n299\n675\n1601")
            assertEquals(514579, day01.part1())
        }

        @Test
        // Testar om part2() returnerar rätt värde med en lista med tre tal som adderar till 2020
        fun testPart2_ReturnsCorrectValue_WithThreeEntries(){
            val day01 = Day012020("1721\n979\n366\n299\n675\n1456")
            assertEquals(241861950, day01.part2())
        }

        @Test
        // Testar om part1() returnerar 0 om det inte finns några tal som adderar till 2020
        fun testPart1_NoSolution() {
            val day01 = Day012020("1\n2\n3\n4")
            assertEquals(0, day01.part1())
        }

        @Test
        // Testar om part2() returnerar 0 om det inte finns några tal som adderar till 2020
        fun testPart2_NoSolution() {
            val day01 = Day012020("1\n2\n3\n4")
            assertEquals(0, day01.part2())
        }

        @Test
        // Testar om parseInput() returnerar en lista med Int från en sträng separerade av newlines
        fun testParseInput_ReturnsListOfInts() {
            val day01 = Day012020("1721\n979\n366\n299\n675\n1456")
            assertEquals(listOf(1721, 979, 366, 299, 675, 1456), day01.parseInput("1721\n979\n366\n299\n675\n1456"))
        }

    }
}