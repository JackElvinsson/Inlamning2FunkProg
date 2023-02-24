package adventofcode.d2_2021

import java.nio.file.Files
import java.nio.file.Paths

//TODO Lägga till uppgiftstexten och inspiration till lösningen

class Day022021NEW(input: List<String>) {

    private val commands = input.map { Command.of(it) }

    // SolvePart1 och SolvePart2 är funktioner som returnerar en int (svar)
    // De använder sig av fold för att iterera över commands och returnera en ny ubåt med nya värden för djup, position och riktning
    // fold tar ett startvärde (Submarine()) och en funktion som tar en ubåt och ett command och returnerar en ny ubåt
    // fold returnerar sedan den sista ubåten
    fun solvePart1(): Int =
        commands.fold(Submarine()) { submarine, command -> submarine.movePart1(command) }.answer()

    fun solvePart2(): Int =
        commands.fold(Submarine()) { submarine, command -> submarine.movePart2(command) }.answer()

    // En dataklass som representerar en ubåt med djup, position och riktning (aim)
    private data class Submarine(val depth: Int = 0, val position: Int = 0, val aim: Int = 0) {
        fun answer() = depth * position

        // movePart1 och movePart2 är båda funktioner som tar in ett command och returnerar en ny ubåt med nya värden för djup, position och riktning
        fun movePart1(command: Command): Submarine =
            when (command.name) {
                "forward" -> copy(position = position + command.amount)
                "down" -> copy(depth = depth + command.amount)
                "up" -> copy(depth = depth - command.amount)
                else -> error("Invalid command")
            }

        fun movePart2(command: Command) =
            when (command.name) {
                "forward" -> copy(
                    position = position + command.amount,
                    depth = depth + (aim * command.amount)
                )
                "down" -> copy(aim = aim + command.amount)
                "up" -> copy(aim = aim - command.amount)
                else -> error("Invalid command")
            }
    }

    // Klassen command representerar ett kommando som kan utföras på en ubåt
    // Kommandot består av ett namn och ett antal
    // Exempel: "forward 10" eller "down 5"
    // Klassen har ett companion object som har en funktion som i sin tyr tar in en sträng och returnerar ett Command-objekt
    // Ett companion object är en statisk klass som kan användas för att skapa objekt utan att behöva skapa en instans av klassen (Tack Reddit)
    // Exempel: Command.of("forward 10")

    private class Command(val name: String, val amount: Int) {
        companion object {
            fun of(input: String) = input.split(" ").let { Command(it.first(), it.last().toInt()) }
        }
    }
}

fun main() {
    val inputFilePath = "src/main/resources/diveDate_d2_2021"
    val inputString = Files.readString(Paths.get(inputFilePath))
    val day02 = Day022021NEW(inputString.lines())

    println("Part 1: ${day02.solvePart1()}")
    println("Part 2: ${day02.solvePart2()}")
}