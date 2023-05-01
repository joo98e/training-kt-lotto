package domain.lotto

object LottoMachine {
    val originLottoNums: List<Int> = (1..45).toList()
    private const val LOTTO_NUM_LENGTH: Int = 6

    fun execute(): Pair<List<Int>, Int> {
        val resultNums = this.originLottoNums.shuffled().subList(0, LOTTO_NUM_LENGTH)
        val resultBonusNum = this.originLottoNums.shuffled().first { it !in resultNums }
        return Pair(resultNums, resultBonusNum)
    }
}