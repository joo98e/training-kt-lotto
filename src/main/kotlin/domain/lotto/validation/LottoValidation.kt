package domain.lotto.validation

import domain.lotto.constants.LottoConstant

object LottoValidation {
    fun isNotRangeForWinningNum(nums: Int): Boolean {
        return nums !in LottoConstant.WINNING_NUM_RANGE
    }
}