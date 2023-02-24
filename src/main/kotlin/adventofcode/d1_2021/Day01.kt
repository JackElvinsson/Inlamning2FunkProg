package adventofcode.d1_2021

import java.nio.file.Files
import java.nio.file.Paths


/*

--- Day 1: Sonar Sweep ---
For example, suppose you had the following report:

199
200
208
210
200
207
240
269
260
263

This report indicates that, scanning outward from the submarine,
the sonar sweep found depths of 199, 200, 208, 210, and so on.

The first order of business is to figure out how quickly the depth increases,
just so you know what you're dealing with
- you never know if the keys will get carried into deeper water by an ocean
current or a fish or something.

To do this, count the number of times a depth measurement
increases from the previous measurement.
(There is no measurement before the first measurement.)
In the example above, the changes are as follows:

199 (N/A - no previous measurement)
200 (increased)
208 (increased)
210 (increased)
200 (decreased)
207 (increased)
240 (increased)
269 (increased)
260 (decreased)
263 (increased)

In this example, there are 7 measurements that are larger than the previous measurement.
How many measurements are larger than the previous measurement?

--- Part Two ---
Considering every single measurement isn't as useful as you expected: there's just too much noise in the data.
Instead, consider sums of a three-measurement sliding window. Again considering the above example:

199  A
200  A B
208  A B C
210    B C D
200  E   C D
207  E F   D
240  E F G
269    F G H
260      G H
263        H

Start by comparing the first and second three-measurement windows.
The measurements in the first window are marked A (199, 200, 208);
their sum is 199 + 200 + 208 = 607.
The second window is marked B (200, 208, 210); its sum is 618.
The sum of measurements in the second window is larger than the sum of the first,
so this first comparison increased.

Your goal now is to count the number of times the sum of measurements in this sliding window increases from the previous sum.
So, compare A with B, then compare B with C, then C with D, and so on.
Stop when there aren't enough measurements left to create a new three-measurement sum.

In the above example, the sum of each three-measurement window is as follows:

A: 607 (N/A - no previous sum)
B: 618 (increased)
C: 618 (no change)
D: 617 (decreased)
E: 647 (increased)
F: 716 (increased)
G: 769 (increased)
H: 792 (increased)
In this example, there are 5 sums that are larger than the previous sum.

Consider sums of a three-measurement sliding window. How many sums are larger than the previous sum?
 */

class Day012021(input: List<String>) {

    // Skapar en lista med integers från inputen
    private val depth = input.map { it.toInt() }

    fun part1(): Int {
        var incrementCounter = 0

        // Loopar igenom listan och jämför varje element med nästa element
        // Om nästa element är större än det föregående ökas incrementCounter
        // depth-size - 1 för att undvika ArrayIndexOutOfBoundsException
        for (i in 0 until depth.size - 1) {
            if (depth[i + 1] > depth[i]) {
                incrementCounter++
            }
        }
        return incrementCounter
    }

    fun part2(): Int {
        var incrementCounter = 0

        // Loopar igenom listan och jämför [i] + [i+1] + [i+2] med [i+1] + [i+2] + [i+3]
        // Om [i+1] + [i+2] + [i+3] är större än [i] + [i+1] + [i+2] ökas incrementCounter
        for (i in 0 until depth.size - 3) {
            if (depth[i + 1] + depth[i + 2] + depth[i + 3] > depth[i] + depth[i + 1] + depth[i + 2]) {
                incrementCounter++
            }
        }
        return incrementCounter
    }

}

fun main() {
    val inputFilePath = "src/main/resources/sonarSweepData_d1_2021"
    val inputString = Files.readString(Paths.get(inputFilePath))
    // separerar strängen med newlines och returnerar en lista med integers
    val inputList = inputString.lines() //.lines() returnerar en lista med strängar
    val day01 = Day012021(inputList)

    println("Part 1: ${day01.part1()}")
    println("Part 2: ${day01.part2()}")
}