package AoC_TEST.d2_2022

import adventofcode.d2_2022.Day022022
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day022022Test {

    @Test
    // Testar att solvePart1 returnerar 15 om input är "A X\nB Z\nC Y"
    fun testSolvePart1_ReturnsCorrectScore() {
        val input = "A X\nB Z\nC Y"
        val day02 = Day022022(input)
        assertEquals(15, day02.part01())
    }

    // A-X = Rock vs lose(Scissors) = 0 + 3
    // B-Z = paper vs Win(Scissors) 6 + 3
    // C-Y = Scissors vs Draw(Scissors) 3 + 3
    @Test
    // Testar att solvePart2 returnerar 18 om input är "A X\nB Z\nC Y"
    fun testSolvePart2_ReturnsCorrectScore() {
        val input = "A X\nB Z\nC Y"
        val day02 = Day022022(input)
        assertEquals(18, day02.part02())
    }

    @Test
    // Testar att playerMove returnerar 1 om input är "A X", 2 om input är "B Y" och 3 om input är "C Z"
    fun testPlayerMove_ReturnsCorrectMoveByPlayer() {
        val day02 = Day022022("")
        assertEquals(1, day02.playerMove("A X"))
        assertEquals(2, day02.playerMove("B Y"))
        assertEquals(3, day02.playerMove("C Z"))
    }

    @Test
    // Testar att parseInput returnerar en lista med "A X", "B Y" och "C Z" om input är "A X\nB Y\nC Z"
    fun testParseInput_ReturnsExpectedListOfLetterPairs() {
        val day02 = Day022022("")
        assertEquals(listOf("A X", "B Y", "C Z"), day02.parseInput("A X\nB Y\nC Z"))
        assertEquals(listOf("A X", "B Y", "C Z"), day02.parseInput("A X\r\nB Y\r\nC Z"))
        assertEquals(listOf("", "A X", "B Y", "C Z"), day02.parseInput("\nA X\nB Y\nC Z"))
    }


}