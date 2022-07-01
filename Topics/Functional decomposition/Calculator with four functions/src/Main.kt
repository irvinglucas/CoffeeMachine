// Implement your functions here
fun subtractTwoNumbers(a: Long, b: Long) {
    val result = a - b
    println(result)
}

fun sumTwoNumbers(a: Long, b: Long) {
    val result = a + b
    println(result)
}

fun divideTwoNumbers(a: Long, b: Long) {
    if (b == 0L) {
        println("Division by 0!")
    } else {
        val result = a / b
        println(result.toString())
    }
}

fun multiplyTwoNumbers(a: Long, b: Long) {
    val result = a * b
    println(result)
}