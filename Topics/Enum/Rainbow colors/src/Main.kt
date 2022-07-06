fun main() {
    val color: String = readln()
    var check: Boolean = false
    for (enum in Rainbow.values()) {
        if (color.uppercase() == enum.name) {
            check = true
            break
        }
    }
    print(check)

}

enum class Rainbow(val color: String) {
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue"),
    INDIGO("indigo"),
    VIOLET("violet");
}