package AoC_TEST.d1_2021


import adventofcode.d1_2021.Day012021
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day012021Test {


    @Test
    // Testar att solvePart1 returnerar 2 om två summor är större än föregående
    fun testSolvePart1_ReturnsCorrectIntegerValue() {
        val input = listOf("1", "2", "3", "2", "1")
        val day = Day012021(input)
        assertEquals(2, day.part1())
    }

    @Test
    // testar att solvePart2 returnerar 1 om en summa (tre tal) är större än föregående
    fun testSolvePart2_ReturnsOne_WhenOneSumIsGreater() {
        val input = listOf("1", "2", "3", "5")
        val day = Day012021(input)
        println(day.part2())
        assertEquals(1, day.part2())
    }

    @Test
    // Testar att solvePart2 returnerar 2 om två summor är större än föregående
    fun testSolvePart2_ReturnsTwo_WhenTwoSumsAreGreater() {
        val input = listOf("1", "2", "4", "5", "6")
        val day = Day012021(input)
        assertEquals(2, day.part2())
    }

    @Test
    // Testar att solvePart2 returnerar 0 om input är för kort
    fun testSolvePart2_ReturnsZero_WhenInputIsTooShort() {
        val input = listOf("1", "2", "3")
        val day = Day012021(input)
        assertEquals(0, day.part2())
    }

    @Test
    //Testar att solvePart2 returnerar 0 om input är tom
    fun testSolvePart2_ReturnsZero_WhenInputIsEmpty() {
        val input = emptyList<String>()
        val day = Day012021(input)
        assertEquals(0, day.part2())
    }

}