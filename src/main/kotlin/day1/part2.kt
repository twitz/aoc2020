package day1

import java.io.File
import java.util.*

/**
 * Brute force ftw
 */
fun main() {
    val tree = parseFile()
    val sortedList = tree.toList()
    sortedList.forEach { i ->
        var currentSum = 0
        sortedList.forEach { j ->
            sortedList.forEach { k ->
                currentSum = i + j + k
                if (currentSum == 2020) {
                    println(i * j * k)
                }
            }
        }
    }
}

private fun parseFile(): TreeSet<Int> {
    val fileName = "src/main/resources/day1_expense_report.txt"
    val set = TreeSet<Int>()
    File(fileName).forEachLine {
        set.add(it.toInt())
    }
    return set
}