package day2

class PasswordEntry(entryString: String) {
    val entryArray: List<String> = entryString.split(" ")
    val password: String = entryArray[2]
}