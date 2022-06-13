fun main() {
    // write your code here

    val number1 = readln().toInt()
    val number2 = readln().toInt()
    val number3 = readln().toInt()
    val number4 = readln().toInt()
    val number5 = readln().toInt()

    if (number5 in number1..number2 || number5 in number3..number4) { print(true) }
    else print(false)
}