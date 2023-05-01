package domain.lotto

import constants.lotto.LottoConstant

object LottoValidation {
    fun isNotRangeForWinningNums(nums: List<Int>): Boolean {
        return !nums.any { it in LottoConstant.WINNING_NUM_RANGE }
    }
}