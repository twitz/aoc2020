package day2

import kotlin.math.min

class MinMaxValidator : Validator() {
    companion object {
        private const val REGEX_FORMAT = "^([^%char]*[%char][^%char]*){%min,%max}\$"
    }

    override fun toRegex(entryArray: List<String>): Regex {
        val minMax = entryArray[0].split("-")
        val character = entryArray[1].replace(":", "")
        val regex = REGEX_FORMAT
                .replace("%char", character)
                .replace("%min", minMax[0])
                .replace("%max", minMax[1])
        return Regex(regex)
    }
}