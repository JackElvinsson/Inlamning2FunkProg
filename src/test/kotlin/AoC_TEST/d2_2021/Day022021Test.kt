package AoC_TEST.d2_2021

import adventofcode.d2_2021.Day022021
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


    class Day022021Test {

        @Test
        // Testar om solvePart01 returnerar rätt värde
        fun testSolvePart01_ReturnsExpectedValue() {
            val input = "forward 10\nup 2\ndown 4\nforward 5\n"
            val day02 = Day022021(input)
            assertEquals(30, day02.part01())
        }

        @Test
        //testa om solvePart02 returnerar rätt värde
        fun testSolvePart02_ReturnsExpectedValue() {
            val input = "forward 10\nup 2\ndown 4\nforward 5\n"
            val day02 = Day022021(input)
            assertEquals(150, day02.part02())
        }
    }