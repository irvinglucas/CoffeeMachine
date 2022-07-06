enum class DaysOfTheWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

fun main() {

    println(DaysOfTheWeek.values()[6])

    for (enum in DaysOfTheWeek.values()){
        if (enum.ordinal != 6){
            println(enum.name)
        } else break
    }
}