package domain.lotto

import constants.lotto.LottoConstant

object LottoMachine {
    val originLottoNums: List<Int> = (1..45).toList()

    fun execute(): Pair<List<Int>, Int> {
        val resultNums = this.originLottoNums.shuffled().subList(0, LottoConstant.LOTTO_NUM_LENGTH)
        val resultBonusNum = this.originLottoNums.shuffled().first { it !in resultNums }
        return Pair(resultNums, resultBonusNum)
    }
}