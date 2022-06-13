// write your function here
fun isVowel(letter: Char): Boolean {
    if (letter == 'a' ||
        letter == 'e' ||
        letter == 'i' ||
        letter == 'o' ||
        letter == 'u' ||
        letter == 'A' ||
        letter == 'E' ||
        letter == 'I' ||
        letter == 'O' ||
        letter == 'U') {
        return true
    }
    return false
}


fun main() {
    val letter = readLine()!!.first()

    println(isVowel(letter))
}