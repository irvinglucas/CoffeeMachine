fun main() {
    val invitation = readLine().toBoolean() // read other value in the same way
    // write your code here
    val gift = readln().toBoolean()

    if (invitation && gift) println("true")
    else println("false")
}