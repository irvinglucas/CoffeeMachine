fun main() {
    // write your code here
    val number1 = readln().toInt()
    val number2 = readln().toInt()
    val number3 = readln().toInt()

    if (number1 in number2..number3) print(true)
    else print(false)
}