package day2

abstract class Validator {

    fun validate(entry: PasswordEntry): Boolean {
        return toRegex(entry.entryArray).matches(entry.password)
    }

    abstract fun toRegex(entryArray: List<String>): Regex
}