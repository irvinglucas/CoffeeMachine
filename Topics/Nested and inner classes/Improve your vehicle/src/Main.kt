class Vehicle(name: String) {
    // add name
    val name = name
    // create constructor

    inner class Engine(horsePower: Int) {
        // add horsePower
        val horsePower = horsePower
        // create constructor

        fun start() {
            println("RRRrrrrrrr....")
        }

        // create function printHorsePower()
        fun printHorsePower() {
            println("The $name vehicle has $horsePower horsepower.")
        }
    }
}