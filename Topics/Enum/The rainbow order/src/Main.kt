enum class Rainbow(val color: String, val rgb: String) {
    RED("Red", "#FF0000"),
    ORANGE("Orange", "#FF7F00"),
    YELLOW("Yellow", "#FFFF00"),
    GREEN("Green", "#00FF00"),
    BLUE("Blue", "#0000FF"),
    INDIGO("Indigo", "#4B0082"),
    VIOLET("Violet", "#8B00FF")
}

fun main() {
    val color = readLine()!!
    // put your code here
    for (enum in Rainbow.values()) {
        if (enum.color.uppercase() == color.uppercase()) {
            println(enum.ordinal + 1)
            break
        }
    }
}

