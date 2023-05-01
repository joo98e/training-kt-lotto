package domain.lotto

import constants.lotto.LottoConstant

object LottoMachine {
    fun execute(): Pair<List<Int>, Int> {
        val resultNums = LottoConstant.WINNING_NUM_RANGE.shuffled().subList(0, LottoConstant.LOTTO_NUM_LENGTH)
        val resultBonusNum = LottoConstant.WINNING_NUM_RANGE.shuffled().first { it !in resultNums }
        return Pair(resultNums, resultBonusNum)
    }
}