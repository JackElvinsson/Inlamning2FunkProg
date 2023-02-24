package adventofcode.d2_2021

import java.nio.file.Files
import java.nio.file.Paths

/*
--- Day 2: Dive! ---
Now, you need to figure out how to pilot this thing.

It seems like the submarine can take a series of commands like forward 1, down 2, or up 3:

forward X increases the horizontal position by X units.
down X increases the depth by X units.
up X decreases the depth by X units.
Note that since you're on a submarine, down and up affect your depth,
and so they have the opposite result of what you might expect.

The submarine seems to already have a planned course (your puzzle input).
You should probably figure out where it's going. For example:

forward 5
down 5
forward 8
up 3
down 8
forward 2

Your horizontal position and depth both start at 0.
The steps above would then modify them as follows:

forward 5 adds 5 to your horizontal position, a total of 5.
down 5 adds 5 to your depth, resulting in a value of 5.
forward 8 adds 8 to your horizontal position, a total of 13.
up 3 decreases your depth by 3, resulting in a value of 2.
down 8 adds 8 to your depth, resulting in a value of 10.
forward 2 adds 2 to your horizontal position, a total of 15.
After following these instructions, you would have a horizontal
position of 15 and a depth of 10. (Multiplying these together produces 150.)

Calculate the horizontal position and depth you would have after following the planned course.
What do you get if you multiply your final horizontal position by your final depth?


--- Part Two ---
Based on your calculations, the planned course doesn't seem to make any sense.
You find the submarine manual and discover that the process
is actually slightly more complicated.

In addition to horizontal position and depth, you'll also need to track a third value,
aim, which also starts at 0. The commands also mean something entirely different than you first thought:

down X increases your aim by X units.
up X decreases your aim by X units.
forward X does two things:
It increases your horizontal position by X units.
It increases your depth by your aim multiplied by X.

Again note that since you're on a submarine, down and up do the
opposite of what you might expect: "down" means aiming in the positive direction.

Now, the above example does something different:

forward 5 adds 5 to your horizontal position, a total of 5. Because your aim is 0,
your depth does not change.
down 5 adds 5 to your aim, resulting in a value of 5.
forward 8 adds 8 to your horizontal position, a total of 13. Because your aim is 5,
your depth increases by 8*5=40.
up 3 decreases your aim by 3, resulting in a value of 2.
down 8 adds 8 to your aim, resulting in a value of 10.
forward 2 adds 2 to your horizontal position, a total of 15. Because your aim is 10,
 your depth increases by 2*10=20 to a total of 60.
After following these new instructions, you would have a horizontal position of 15 and a depth of 60.
(Multiplying these produces 900.)

Using this new interpretation of the commands, calculate the horizontal position and depth
you would have after following the planned course.
What do you get if you multiply your final horizontal position by your final depth?
 */

class Day022021(input: String) {

    private val dataInput = parseInput(input)

    // part01 börjar med att sätta positionerna till 0
    // sedan itereras listan och positionerna ändras beroende på vilken riktning som är angiven
    // Om riktningen är forward ökas horisontella positionen med antalet steg
    // Om riktningen är up minskas vertikala positionen med antalet steg
    // Om riktningen är down ökas vertikala positionen med antalet steg
    // sedan returneras horisontella positionen gånger vertikala positionen
    internal fun part01(): Int {

        var horizontalPosition = 0
        var verticalPosition = 0

        // sublist är en funktion som tar in en lista och returnerar en del av listan
        // detta används för att iterera över listan utan att ändra på den
        // Eftersom varje element i listan är en sträng så måste den splittas, för att sedan kunna konverteras till int
        // Sedan kan vi tack vare subList plocka ut index 0 och 1 från listan för att få fram riktningen och antalet steg
        for (i in dataInput.subList(0, dataInput.size)) {

            val split = i.split(" ")

            if (split[0] == "forward") {
                horizontalPosition += split[1].toInt()
            } else if (split[0] == "up") {
                verticalPosition -= split[1].toInt()
            } else if (split[0] == "down") {
                verticalPosition += split[1].toInt()
            }

        }
        return horizontalPosition * verticalPosition
    }

    // part02 fungerar ungefär som part01
    // Skillnaden är att det finns en variabel som håller koll på vilket håll båten är riktad
    // Om riktningen är forward ökas horisontella positionen med antalet steg gånger riktningen (aim)
    // Om riktningen är up minskas vertikala positionen med antalet steg gånger riktningen (aim)
    // Om riktningen är down ökas vertikala positionen med antalet steg gånger riktningen (aim)
    // sedan returneras horisontella positionen gånger vertikala positionen
    internal fun part02(): Int {

        var horizontalPosition = 0
        var verticalPosition = 0
        var aim = 0

        for (i in dataInput.subList(0, dataInput.size)) {

            val split = i.split(" ")

            if (split[0] == "forward") {
                horizontalPosition += split[1].toInt()
                verticalPosition += (aim * split[1].toInt())
            } else if (split[0] == "up") {
                aim -= split[1].toInt()
            } else if (split[0] == "down") {
                aim += split[1].toInt()
            }

        }
        return horizontalPosition * verticalPosition
    }

}

// parseInput tar in en sträng och returnerar en lista med strängar som är separerade av newlines
internal fun parseInput(input: String): List<String> {
    return input.split("\n").map { it.trim() }
}


fun main() {
    val inputFilePath = "src/main/resources/diveDate_d2_2021"
    val inputString = Files.readString(Paths.get(inputFilePath))
    val day02 = Day022021(inputString)

    println("Part 1: ${day02.part01()}")
    println("Part 2: ${day02.part02()}")
}
