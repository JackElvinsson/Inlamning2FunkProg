package adventofcode.d2_2022

import java.nio.file.Files
import java.nio.file.Paths

/*
--- Day 2: Rock Paper Scissors ---
one Elf gives you an encrypted strategy guide (your puzzle input) that they say will be sure to help you win.
"The first column is what your opponent is going to play: A for Rock, B for Paper, and C for Scissors.
The second column--" Suddenly, the Elf is called away to help with someone's tent.

The second column, you reason, must be what you should play in response: X for Rock, Y for Paper, and Z for Scissors.
Winning every time would be suspicious, so the responses must have been carefully chosen.

The winner of the whole tournament is the player with the highest score.
Your total score is the sum of your scores for each round.
The score for a single round is the score for the shape you selected
(1 for Rock, 2 for Paper, and 3 for Scissors) plus the score for the outcome
of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).

Since you can't be sure if the Elf is trying to help you or trick you,
you should calculate the score you would get if you were to follow the strategy guide.

For example, suppose you were given the following strategy guide:

A Y
B X
C Z

This strategy guide predicts and recommends the following:

In the first round, your opponent will choose Rock (A), and you should choose Paper (Y).
This ends in a win for you with a score of 8 (2 because you chose Paper + 6 because you won).
In the second round, your opponent will choose Paper (B), and you should choose Rock (X).
This ends in a loss for you with a score of 1 (1 + 0).
The third round is a draw with both players choosing Scissors, giving you a score of 3 + 3 = 6.
In this example, if you were to follow the strategy guide, you would get a total score of 15 (8 + 1 + 6).

What would your total score be if everything goes exactly according to your strategy guide?

--- Part Two ---
The Elf finishes helping with the tent and sneaks back over to you.
"Anyway, the second column says how the round needs to end: X means you need to lose,
Y means you need to end the round in a draw, and Z means you need to win. Good luck!"

The total score is still calculated in the same way,
but now you need to figure out what shape to choose so the round ends as indicated.
The example above now goes like this:

In the first round, your opponent will choose Rock (A),
and you need the round to end in a draw (Y), so you also choose Rock.
This gives you a score of 1 + 3 = 4.
In the second round, your opponent will choose Paper (B),
and you choose Rock, so you lose (X) with a score of 1 + 0 = 1.
In the third round, you will defeat your opponent's Scissors with Rock for a score of 1 + 6 = 7.
Now that you're correctly decrypting the ultra top secret strategy guide,
you would get a total score of 12.

Following the Elf's instructions for the second column, what would your total score be if everything goes exactly according to your strategy guide?
 */

class Day022022(input: String) {

    // parseInput tar in en sträng och returnerar en lista med strängar som är separerade av newlines
    private val solutions = parseInput(input)

    // part01 börjar med kolla om jag vann rundan, om jag vann så ska jag lägga till 6 poäng till mina totala poäng + 1, 2 eller 3 poäng beroende på vilket val jag gjorde
    // om jag inte vann rundan så ska jag lägga till 0 poäng till mina totala poäng + 1, 2 eller 3 poäng beroende på vilket val jag gjorde
    // om rundan blev lika så ska jag lägga till 3 poäng till mina totala poäng + 1, 2 eller 3 poäng beroende på vilket val jag gjorde
    // Slutligen skrivs totala poängen ut
    fun part01(): Int {
        var totalPoints = 0
        solutions.forEach {

            // Kollar efter vinnande kombination och lägger till poäng för mitt val
            if ((it.first() == 'A' && it.last() == 'Y') || // sten påse
                (it.first() == 'B' && it.last() == 'Z') || // sax sten
                (it.first() == 'C' && it.last() == 'X')
            ) { // påse sax

                totalPoints += 6

                // Kollar efter lika kombination och lägger till poäng för mitt val
            } else if ((it.first() == 'A' && it.last() == 'X') || // sten sten
                (it.first() == 'B' && it.last() == 'Y') || // sax sax
                (it.first() == 'C' && it.last() == 'Z')
            ) { // påse påse

                totalPoints += 3

                // Kollar efter förlorande kombination och lägger till poäng för mitt val
            } else {
                totalPoints += 0
            }
            totalPoints += playerMove(it)
        }
        return totalPoints
    }


    // part02 kollar istället om jag ska vinna, förlora eller få lika och lägger till poäng för mitt val
    // om rundan ska vinnas läggs 6 poäng till mina totala poäng + 1, 2 eller 3 poäng beroende på vilket val jag gjorde
    // om rundan ska förloras läggs 0 poäng till mina totala poäng + 1, 2 eller 3 poäng beroende på vilket val jag gjorde
    // om rundan ska bli lika läggs 3 poäng till mina totala poäng + 1, 2 eller 3 poäng beroende på vilket val jag gjorde
    // Slutligen skrivs totala poängen ut
    fun part02(): Int {
        var totalPoints = 0
        solutions.forEach {

            // Om X - Förlust
            if ((it.last() == 'X')) {
                if (it.first() == 'A') totalPoints += playerMove("Z")
                if (it.first() == 'B') totalPoints += playerMove("X")
                if (it.first() == 'C') totalPoints += playerMove("Y")

                //Om Y - Lika
            } else if ((it.last() == 'Y')) {
                if (it.first() == 'A') totalPoints += playerMove("X")
                if (it.first() == 'B') totalPoints += playerMove("Y")
                if (it.first() == 'C') totalPoints += playerMove("Z")

                totalPoints += 3

                // Om Z - Vinst
            } else if ((it.last() == 'Z')) {
                if (it.first() == 'A') totalPoints += playerMove("Y")
                if (it.first() == 'B') totalPoints += playerMove("Z")
                if (it.first() == 'C') totalPoints += playerMove("X")

                totalPoints += 6
            }

        }
        return totalPoints
    }

    // playerMove returnerar 1, 2 eller 3 beroende på vilket val jag gjorde
    internal fun playerMove(move: String): Int {

        return when (move.trim().last()) {
            'X' -> 1 //ROCK
            'Y' -> 2 //PAPER
            'Z' -> 3 //SCISSORS
            else -> 0

        }
    }

    // parseInput delar upp inputsträngen i en lista med varje rad som en sträng
    internal fun parseInput(input: String): List<String> {
        return input.split("\n").map { it.trim() }
    }
}


fun main() {
    val inputFilePath = "src/main/resources/rockPaperSciccorsData_d2_2022"
    val inputString = Files.readString(Paths.get(inputFilePath))
    val day02 = Day022022(inputString)

    println("Part 1: ${day02.part01()}")
    println("Part 2: ${day02.part02()}")
}
