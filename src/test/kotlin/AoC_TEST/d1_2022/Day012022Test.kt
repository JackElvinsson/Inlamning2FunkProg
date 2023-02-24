package AoC_TEST.d1_2022

import createIntList
import part02
import part01
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import java.io.File

class Day012022Test {

    @Test
    // Testar att readInputFile returnerar en lista med 8 element
    fun testReadInputFile_ReturnsExpectedList() {
        val expected = listOf("9548", "3738", "", "18492", "17104", "1738", "", "1769")
        val actual = File("src/main/resources/calorieData_d1_2022").readLines().take(8)
        println(actual.size)
        assertEquals(expected, actual)
    }

    @Test
    // Testar att createIntList returnerar en lista med 4 element av typen Int
    fun testCreateIntList_ReturnsExpectedList() {
        val expected = listOf(13286, 37334, 45854, 51611)
        val actual = createIntList().take(4)
        assertEquals(expected, actual)
    }

    @Test
    // Testar att part01 returnerar det största talet i listan
    fun testHighestValue_ReturnsLargestNumberInList() {
        val list = listOf(3, 12, 6)
        val expected = 12
        val actual = part01(list)
        assertEquals(expected, actual)
    }

    @Test
    // Testar att part02 returnerar summan av de tre största talen i listan
    fun testGetHighestThreeTotal_ReturnsCorrectTotal_ForUniqueNumbers() {
        val list = listOf(1, 5, 3, 7, 9, 6)
        val expectedTotal = 22
        val actualTotal = part02(list)
        assertEquals(expectedTotal, actualTotal)
    }

    @Test
    // Testar att part02 returnerar summan av de tre största talen i listan även om det finns dubbletter
    fun testGetHighestThreeTotal_ReturnsCorrectTotal_ForRepeatedNumbers() {
        val list = listOf(1, 5, 3, 7, 9, 6, 9, 8)
        val expectedTotal = 26
        val actualTotal = part02(list)
        assertEquals(expectedTotal, actualTotal)

    }
}