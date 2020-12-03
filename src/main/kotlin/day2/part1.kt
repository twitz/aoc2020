package day2

import java.io.File

fun main() {
    val validator = MinMaxValidator()
    parseFile().stream()
            .map(::PasswordEntry)
            .filter(validator::validate)
            .count()
            .also(::println)
}

private fun parseFile(): List<String> {
    val fileName = "src/main/resources/day2_passwords.txt"
    return File(fileName).readLines()
}