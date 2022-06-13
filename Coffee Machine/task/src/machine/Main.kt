package machine

const val DEFAULT_WATER_ML = 200
const val DEFAULT_MILK_ML = 50
const val DEFAULT_BEANS_GRAMS = 15

fun main() {
    print("Write how many ml of water the coffee machine has: > ")
    val quantityOfWater = readln().toInt()
    print("Write how many ml of milk the coffee machine has: > ")
    val quantityOfMilk = readln().toInt()
    print("Write how many grams of coffee beans the coffee machine has: >")
    val gramsOfCoffeeBeans = readln().toInt()
    print("Write how many cups of coffee will you need: >")
    val quantityOfCups = readln().toInt()

    val maxCupsWater = quantityOfWater / DEFAULT_WATER_ML
    val maxCupsMilk = quantityOfMilk / DEFAULT_MILK_ML
    val maxCupsBeans = gramsOfCoffeeBeans / DEFAULT_BEANS_GRAMS

    val maxCups = minOf(maxCupsWater, maxCupsMilk, maxCupsBeans)

    if (quantityOfCups == maxCups) println("Yes, I can make that amount of coffee")
    else if (quantityOfCups < maxCups) println("Yes, I can make that amount of coffee( and even " + (maxCups-quantityOfCups) + "more than that")
    else println("No, I can make only $maxCups cups of coffee")

}
