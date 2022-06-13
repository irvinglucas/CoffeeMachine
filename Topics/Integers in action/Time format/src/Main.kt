const val SECONDS_OF_A_DAY = 86400
const val SECONDS_OF_AN_HOUR = 3600

fun main() {
    val totalSeconds = System.currentTimeMillis() / 1000 // dont change this line

    val hours = totalSeconds % SECONDS_OF_A_DAY / SECONDS_OF_AN_HOUR
    val minutes = (totalSeconds % SECONDS_OF_A_DAY) % SECONDS_OF_AN_HOUR / 60
    val seconds = (totalSeconds % SECONDS_OF_A_DAY) % SECONDS_OF_AN_HOUR % 60

    print("$hours:$minutes:$seconds")
}