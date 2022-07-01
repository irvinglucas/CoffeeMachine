class Vehicle {
    inner class Engine {
        fun start() {
            println("RRRrrrrrrr....")
        }
    }
}
// do not touch the class above

fun main() {
    // start your vehicle, put your code here
    val vehicle = Vehicle()
    val engine = vehicle.Engine()
    engine.start()
}