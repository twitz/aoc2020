package day2

class PosValidator : Validator() {
    companion object {
        private const val REGEX_FORMAT = "^(.{%o1}%char.{%o2}[^%char].*)|(.{%o1}[^%char].{%o2}%char.*)\$"
    }

    override fun toRegex(entryArray: List<String>): Regex {
        val positions = entryArray[0].split("-")
        val firstOffset = positions[0].toInt() - 1
        val secondOffset = positions[1].toInt() - positions[0].toInt() - 1
        val character = entryArray[1].replace(":", "")
        val regex = REGEX_FORMAT
                .replace("%o1", firstOffset.toString())
                .replace("%char", character)
                .replace("%o2", secondOffset.toString())
        return Regex(regex)
    }
}