package day1

import java.io.File
import java.lang.RuntimeException
import java.util.*

fun main() {
    val tree = parseFile()
    println(findValue(tree))
}

private fun parseFile(): TreeSet<Int> {
    val fileName = "src/main/resources/day1_expense_report.txt"
    val set = TreeSet<Int>()
    File(fileName).forEachLine {
        set.add(it.toInt())
    }
    return set
}

private fun findValue(tree: TreeSet<Int>): Int {
    return findValue(tree, tree.first(), tree.last())
}

private fun findValue(tree: TreeSet<Int>, first: Int, last: Int): Int {
    val sum = first + last
    return when {
        sum < 2020 -> {
            val nextFirst = tree.higher(first) ?: throw RuntimeException("Couldn't find value")
            findValue(tree, nextFirst, last)
        }
        sum > 2020 -> {
            val nextLast = tree.lower(last) ?: throw RuntimeException("Couldn't find value")
            findValue(tree, first, nextLast)
        }
        else -> {
            first * last
        }
    }
}