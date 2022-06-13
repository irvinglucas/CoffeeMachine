package machine

import kotlin.system.exitProcess

// espresso needed resources
const val ESPRESSO_WATER = 250 // in ml
//const val ESPRESSO_MILK = 0 // in ml
const val ESPRESSO_BEANS = 16 //in grams
const val ESPRESSO_COST = 4 // in dollars

// latte needed resources

const val LATTE_WATER = 350
const val LATTE_MILK = 75
const val LATTE_BEANS = 20
const val LATTE_COST = 7
// cappuccino needed resources

const val CAPPUCCINO_WATER = 200
const val CAPPUCCINO_MILK = 100
const val CAPPUCCINO_BEANS = 12
const val CAPPUCCINO_COST = 6

// coffee machine with initial resources
private var amountOfWater = 400
private var amountOfMilk = 540
private var amountOfCoffeeBeans = 120
private var amountOfDisposableCups = 9
private var amountOfMoney = 550

fun main() {
    while (true) mainMenu()
}


fun mainMenu () {
    print("Write action (buy, fill, take, remaining, exit): ")
    when (readln()) {
        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
        "remaining" -> remaining()
        "exit" -> exitProcess(0)
    }
}

fun buy () {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
    when (readln()) {
        "1" -> getEspresso()
        "2" -> getLatte()
        "3" -> getCappuccino()
    }
}

// primary functions
fun fill () {
    print("Write how many ml of water do you want to add: ")
    amountOfWater += readln().toInt()
    print("Write how many ml of milk do you want to add: ")
    amountOfMilk += readln().toInt()
    print("Write how many grams of coffee beans do you want to add: ")
    amountOfCoffeeBeans += readln().toInt()
    print("Write how many disposable cups of coffee do you want to add: ")
    amountOfDisposableCups += readln().toInt()
}
fun take () {
    println("I gave you $$amountOfMoney")
    amountOfMoney = 0
}
fun remaining () {
    println("""The coffee machine has:
        |$amountOfWater ml of water
        |$amountOfMilk ml of milk
        |$amountOfCoffeeBeans g of coffee beans
        |$amountOfDisposableCups disposable cups
        |$$amountOfMoney of money
    """.trimMargin())
}

// coffee-making functions
fun getEspresso () {
    if ((amountOfWater >= ESPRESSO_WATER) && (amountOfCoffeeBeans >= ESPRESSO_BEANS) && (amountOfDisposableCups >= 1)){
        println("I have enough resources, making you a coffee!")
        amountOfWater -= ESPRESSO_WATER
        amountOfCoffeeBeans -= ESPRESSO_BEANS
        amountOfDisposableCups -= 1
        amountOfMoney += ESPRESSO_COST
    }
}
fun getLatte () {
    if ((amountOfWater >= LATTE_WATER) && (amountOfMilk >= LATTE_MILK) && (amountOfCoffeeBeans >= LATTE_BEANS) && (amountOfDisposableCups >= 1)){
        println("I have enough resources, making you a coffee!")
        amountOfWater -= LATTE_WATER
        amountOfMilk -= LATTE_MILK
        amountOfCoffeeBeans -= LATTE_BEANS
        amountOfDisposableCups -= 1
        amountOfMoney += LATTE_COST
    }
    else when {
        amountOfWater < LATTE_WATER -> println("Sorry, not enough water!")
    }
}
fun getCappuccino () {
    if ((amountOfWater >= CAPPUCCINO_WATER) && (amountOfMilk >= CAPPUCCINO_MILK) && (amountOfCoffeeBeans >= CAPPUCCINO_BEANS) && (amountOfDisposableCups >= 1)) {
        println("I have enough resources, making you a coffee!")
        amountOfWater -= CAPPUCCINO_WATER
        amountOfMilk -= CAPPUCCINO_MILK
        amountOfCoffeeBeans -= CAPPUCCINO_BEANS
        amountOfDisposableCups -= 1
        amountOfMoney += CAPPUCCINO_COST
    }
}
