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


enum class CoffeeMachineState {
    MAIN_MENU,
    WAITING_ACTION,
    CHOOSING_COFFEE_TYPE,
    FILLING,
    TAKING_MONEY_AWAY,
    CHECK_REMAINING,
    STOPPED;
}

class CoffeeMachine {

    // coffee machine with initial resources
    private var amountOfWater = 400
    private var amountOfMilk = 540
    private var amountOfCoffeeBeans = 120
    private var amountOfDisposableCups = 9
    private var amountOfMoney = 550

    // list to store the resources when the machine is on filling state
    private var fillingResourcesCounter = 0
    private var fillingResourcesMenuCounter = 0

    // Default machine state
    private var machineState = CoffeeMachineState.WAITING_ACTION
    fun runMachine(input: String) {

        when (machineState) {
            // First state of the machine
            CoffeeMachineState.MAIN_MENU -> {
                mainMenu()
                machineState = CoffeeMachineState.WAITING_ACTION
            }

            // Second state of the machine
            CoffeeMachineState.WAITING_ACTION -> {
                when (input) {
                    "buy" -> {
                        // function to print options menu
                        coffeeOptionsMenu()
                        machineState = CoffeeMachineState.CHOOSING_COFFEE_TYPE
                    }
                    "fill" -> {
                        machineState = CoffeeMachineState.FILLING
                        fillMachineMenu()
                    }
                    "take" -> {
                        withdrawMoney()
                        machineState = CoffeeMachineState.WAITING_ACTION
                        mainMenu()

                    }
                    "remaining" -> {
                        getRemainingResources()
                        machineState = CoffeeMachineState.WAITING_ACTION
                        mainMenu()

                    }
                    "exit" -> {
                        //this line is not necessary, but just to make the code more formal, I made this state
                        machineState = CoffeeMachineState.STOPPED
                        exitProcess(0)
                    }
                }
            }
            // Third state of the machine
            CoffeeMachineState.CHOOSING_COFFEE_TYPE -> {
                when (input) {
                    "1" -> {
                        getEspresso()
                        machineState = CoffeeMachineState.WAITING_ACTION
                        mainMenu()
                    }
                    "2" -> {
                        getLatte()
                        machineState = CoffeeMachineState.WAITING_ACTION
                        mainMenu()
                    }
                    "3" -> {
                        getCappuccino()
                        machineState = CoffeeMachineState.WAITING_ACTION
                        mainMenu()
                    }
                    "back" -> {
                        machineState = CoffeeMachineState.WAITING_ACTION
                        mainMenu()
                    }
                }
            }
            // Fourth state of the machine
            CoffeeMachineState.FILLING -> {
                // THIS PART OF THE PROGRAM VERIFIES IF THE MUTABLE LIST HAS AT LEAST ONE
                // ELEMENT. IF NOT, THE FLOW GOES FORWARD*/

                fillMachineMenu()
                fillMachine(input.toInt())
            }
        }
    } // End of runMachine()

    // new functions for the machine
    private fun mainMenu() {
        print("Write action (buy, fill, take, remaining, exit): ")
    }

    private fun coffeeOptionsMenu() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    }

    private fun fillMachineMenu() {
        when (fillingResourcesMenuCounter) {
            0 -> {
                print("Write how many ml of water do you want to add: ")
                ++fillingResourcesMenuCounter
            }
            1 -> {
                print("Write how many ml of milk do you want to add: ")
                ++fillingResourcesMenuCounter
            }
            2 -> {
                print("Write how many grams of coffee beans do you want to add: ")
                ++fillingResourcesMenuCounter
            }
            3 -> {
                print("Write how many disposable cups of coffee do you want to add: ")
                ++fillingResourcesMenuCounter
            }
        }
    }

    private fun getRemainingResources() {
        println(
            """The coffee machine has:
        |$amountOfWater ml of water
        |$amountOfMilk ml of milk
        |$amountOfCoffeeBeans g of coffee beans
        |$amountOfDisposableCups disposable cups
        |$$amountOfMoney of money
    """.trimMargin()
        )
    }

    private fun fillMachine(input: Int) {
        when (fillingResourcesCounter) {
            0 -> {
                amountOfWater += input
                ++fillingResourcesCounter
            }
            1 -> {
                amountOfMilk += input
                ++fillingResourcesCounter
            }
            2 -> {
                amountOfCoffeeBeans += input
                ++fillingResourcesCounter
            }
            3 -> {
                amountOfDisposableCups += input
                fillingResourcesCounter = 0
                machineState = CoffeeMachineState.WAITING_ACTION
                mainMenu()
            }
        }

    }

    private fun withdrawMoney() {
        println("I gave you $$amountOfMoney")
        amountOfMoney = 0
    }

    // coffee-making functions
    private fun getEspresso() {
        if ((amountOfWater >= ESPRESSO_WATER) && (amountOfCoffeeBeans >= ESPRESSO_BEANS) && (amountOfDisposableCups >= 1)) {
            println("I have enough resources, making you a coffee!")
            amountOfWater -= ESPRESSO_WATER
            amountOfCoffeeBeans -= ESPRESSO_BEANS
            amountOfDisposableCups -= 1
            amountOfMoney += ESPRESSO_COST
        }
    }

    private fun getLatte() { //
        if ((amountOfWater >= LATTE_WATER) && (amountOfMilk >= LATTE_MILK) && (amountOfCoffeeBeans >= LATTE_BEANS) && (amountOfDisposableCups >= 1)) {
            println("I have enough resources, making you a coffee!")
            amountOfWater -= LATTE_WATER
            amountOfMilk -= LATTE_MILK
            amountOfCoffeeBeans -= LATTE_BEANS
            amountOfDisposableCups -= 1
            amountOfMoney += LATTE_COST
        } else when {
            amountOfWater < LATTE_WATER -> println("Sorry, not enough water!")
        }
    }

    private fun getCappuccino() {
        if ((amountOfWater >= CAPPUCCINO_WATER) && (amountOfMilk >= CAPPUCCINO_MILK) && (amountOfCoffeeBeans >= CAPPUCCINO_BEANS) && (amountOfDisposableCups >= 1)) {
            println("I have enough resources, making you a coffee!")
            amountOfWater -= CAPPUCCINO_WATER
            amountOfMilk -= CAPPUCCINO_MILK
            amountOfCoffeeBeans -= CAPPUCCINO_BEANS
            amountOfDisposableCups -= 1
            amountOfMoney += CAPPUCCINO_COST
        }
    }

    private fun getMachineState(stage: String) {
        println("Got into the $stage stage ")
        println("Current machine state: $machineState")
        println("Filling resources counter size: $fillingResourcesCounter")
    }
}

// Main program
fun main() {

    val machine = CoffeeMachine()
    var input: String
    print("Write action (buy, fill, take, remaining, exit): ")
    while (true) {
        input = readln()
        machine.runMachine(input)
    }
}