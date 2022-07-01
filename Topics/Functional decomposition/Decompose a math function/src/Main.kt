fun f(x: Double): Double {
    // call your implemented functions here
    var functionResult = 0.0

    if (x <= 0) { functionResult = f1(x) }
    if (x > 0 && x < 1) { functionResult = f2(x) }
    if (x >= 1) { functionResult = f3(x) }

    return functionResult

}

// implement your functions here
fun f1(x: Double): Double {
    return x * x + 1
}

fun f2(x: Double): Double {
    return 1 / (x * x)
}

fun f3(x: Double): Double {
    return x * x - 1
}