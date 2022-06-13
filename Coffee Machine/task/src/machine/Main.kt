package machine

// espresso needed supplies
const val ESPRESSO_WATER = 250 // in ml
//const val ESPRESSO_MILK = 0 // in ml
const val ESPRESSO_BEANS = 16 //in grams
const val ESPRESSO_COST = 4 // in dollars

// latte needed supplies

const val LATTE_WATER = 350
const val LATTE_MILK = 75
const val LATTE_BEANS = 20
const val LATTE_COST = 7

// cappuccino needed supplies
const val CAPPUCCINO_WATER = 200
const val CAPPUCCINO_MILK = 100
const val CAPPUCCINO_BEANS = 12
const val CAPPUCCINO_COST = 6

// coffee machine supplies according to task description
private var amountOfWater = 400
private var amountOfMilk = 540
private var amountOfCoffeeBeans = 120
private var amountOfDisposableCups = 9
private var amountOfMoney = 550


fun main() {

    // this function prints out the machine state using print() function
    getMachineState()
    print("Write action (buy, fill, take): >")
    when(readln()) {
        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
    }
}

// operation functions
// these functions for now only need to print out some text

fun getMachineState () {
    println("""The coffee machine has:
        |$amountOfWater ml of water
        |$amountOfMilk ml of milk
        |$amountOfCoffeeBeans g of coffee beans
        |$amountOfDisposableCups disposable cups
        |$$amountOfMoney of money
    """.trimMargin())
}
fun buy () {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: >")
    when (readln().toInt()) {
        1 -> getEspresso()
        2 -> getLatte()
        3 -> getCappuccino()
    }
}

fun getEspresso () {
    if ((amountOfWater >= ESPRESSO_WATER) && (amountOfCoffeeBeans >= ESPRESSO_BEANS) && (amountOfDisposableCups >= 1)){
        amountOfWater -= ESPRESSO_WATER
        amountOfCoffeeBeans -= ESPRESSO_BEANS
        amountOfDisposableCups -= 1
        amountOfMoney += ESPRESSO_COST
    }
    getMachineState()
}

fun getLatte () {
    if ((amountOfWater >= LATTE_WATER) && (amountOfMilk >= LATTE_MILK) && (amountOfCoffeeBeans >= LATTE_BEANS) && (amountOfDisposableCups >= 1)){
        amountOfWater -= LATTE_WATER
        amountOfMilk -= LATTE_MILK
        amountOfCoffeeBeans -= LATTE_BEANS
        amountOfDisposableCups -= 1
        amountOfMoney += LATTE_COST
    }
    getMachineState()
}

fun getCappuccino () {

    if ((amountOfWater >= CAPPUCCINO_WATER) && (amountOfMilk >= CAPPUCCINO_MILK) && (amountOfCoffeeBeans >= CAPPUCCINO_BEANS) && (amountOfDisposableCups >= 1)) {
        amountOfWater -= CAPPUCCINO_WATER
        amountOfMilk -= CAPPUCCINO_MILK
        amountOfCoffeeBeans -= CAPPUCCINO_BEANS
        amountOfDisposableCups -= 1
        amountOfMoney += CAPPUCCINO_COST
    }
    getMachineState()
}

fun fill () {
    print("Write how many ml of water do you want to add: >")
    amountOfWater += readln().toInt()
    print("Write how many ml of milk do you want to add: >")
    amountOfMilk += readln().toInt()
    print("Write how many grams of coffee beans do you want to add: >")
    amountOfCoffeeBeans += readln().toInt()
    print("Write how many disposable cups of coffee do you want to add: >")
    amountOfDisposableCups += readln().toInt()

    getMachineState()
}

fun take () {
    println("I gave you $amountOfMoney")
    amountOfMoney = 0
    getMachineState()
}
