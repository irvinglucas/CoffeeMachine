fun main(args: Array<String>) {
    val shape = readln().toInt()

    when(shape){
        1 -> print("You have chosen a square")
        2 -> print("You have chosen a circle")
        3 -> print("You have chosen a triangle")
        4 -> print("You have chosen a rhombus")
        else -> print("There is no such shape!")
    }
}