import java.io.File


/*
--- Day 1: Calorie Counting ---
For example, suppose the Elves finish writing their items' Calories and end up with the following list:

1000
2000
3000

4000

5000
6000

7000
8000
9000

10000

This list represents the Calories of the food carried by five Elves:

The first Elf is carrying food with 1000, 2000, and 3000 Calories, a total of 6000 Calories.
The second Elf is carrying one food item with 4000 Calories.
The third Elf is carrying food with 5000 and 6000 Calories, a total of 11000 Calories.
The fourth Elf is carrying food with 7000, 8000, and 9000 Calories, a total of 24000 Calories.
The fifth Elf is carrying one food item with 10000 Calories.
In case the Elves get hungry and need extra snacks, they need to know which Elf to ask: they'd like to know how many Calories are being carried by the Elf carrying the most Calories. In the example above, this is 24000 (carried by the fourth Elf).

Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?

--- Part Two ---
By the time you calculate the answer to the Elves' question,
they've already realized that the Elf carrying the most Calories of food might eventually run out of snacks.
To avoid this unacceptable situation,
the Elves would instead like to know the total Calories carried by the top three Elves carrying the most Calories.
That way, even if one of those Elves runs out of snacks, they still have two backups.
In the example above, the top three Elves are the fourth Elf (with 24000 Calories),
then the third Elf (with 11000 Calories), then the fifth Elf (with 10000 Calories).
The sum of the Calories carried by these three elves is 45000.
Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
 */

// testar utan att skapa upp en klass, because kotlin

internal fun nisseInput() = File("src/main/resources/calorieData_d1_2022").readLines()

val calorieList = createIntList()

// tar in en lista med integers sedan jämförs dessa tal med varandra och det högsta talet skrivs ut.
internal fun part01(list: List <Int>): Int {
    var highest = 0
    list.forEach {
        if (it > highest) {
            highest = it
        }
    }
    return highest
}

// Sorterar listan och returnerar summan av de 3 högsta talen
internal fun part02(list: List <Int>): Int {
    val listSorted = list.sortedDescending()
    return listSorted[0] + listSorted[1] + listSorted[2]
}

// Lägger ihop talen rad för rad tills en tom rad hittas och skapar en lista med dessa tal. Returnerar sedan listan.
internal fun createIntList(): MutableList<Int> {
    val list = mutableListOf<Int>()
    var sum = 0
    nisseInput().forEach {
        if (it != "") {
            sum += it.toInt()
        } else {
            list.add(sum)
            sum = 0
        }
    }
    return list
}


fun main() {
    println("Part 1: ${part01(calorieList)}")
    println("Part 2: ${part02(calorieList)}")
}
