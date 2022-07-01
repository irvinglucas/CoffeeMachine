const val MINIMUM_TIP_PERCENTAGE = 10
fun tip(bill: Int, percentage: Int = MINIMUM_TIP_PERCENTAGE): Int {
    return bill / 100 * percentage
}