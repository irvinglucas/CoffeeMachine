// some const val's to get a more readable and clean code
const val LIST_SIZE = 4
const val TOTAL_FOOD_COST_PER_DAY_INDEX = 1
const val ONE_WAY_FLIGHT_COST_INDEX = 2
const val ONE_NIGHT_HOTEL_COST_INDEX = 3

fun main() {
    val costList = MutableList(LIST_SIZE) { readln().toInt() }

    println(costList[0] * costList[TOTAL_FOOD_COST_PER_DAY_INDEX] + costList[ONE_WAY_FLIGHT_COST_INDEX] * 2 + (costList[0] - 1) * costList[ONE_NIGHT_HOTEL_COST_INDEX])

}