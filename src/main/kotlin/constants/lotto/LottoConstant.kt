package constants.lotto

import enums.LottoWinner

object LottoConstant {
    const val LOTTO_NUM_LENGTH = 6

    val PRIZE_MAP = mapOf(
        LottoWinner.FIFTH_PLACE to 2_000_000_000,
        LottoWinner.SECOND_PLACE to 30_000_000,
        LottoWinner.THIRD_PLACE to 1_500_000,
        LottoWinner.FOURTH_PLACE to 50_000,
        LottoWinner.FIFTH_PLACE to 5_000
    )
}