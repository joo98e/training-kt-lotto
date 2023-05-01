package domain.lotto

import common.exception.ExpectedException
import constants.lotto.LottoConstant
import enums.LottoWinner

class LottoResult(
    private val lottoTickets: List<LottoTicket>,
    private val lastWeekWinningNumbers: List<Int>,
    private val lastWeekWinningBonusNum: Int
) {
    private var result: MutableList<LottoWinner> = mutableListOf()

    init {
        if (this.lastWeekWinningNumbers.size != LottoConstant.LOTTO_NUM_LENGTH) {
            throw ExpectedException("당첨 번호의 size 는 6이어야 합니다.")
        }

        if (this.lastWeekWinningBonusNum in this.lastWeekWinningNumbers) {
            throw ExpectedException("당첨 번호에 보너스 번호가 포함될 수 없습니다.")
        }

        calculateResult()
    }

    private fun calculateResult() {
        lottoTickets.forEach { ticket ->
            val lottoWinner = pair(this.lastWeekWinningNumbers, this.lastWeekWinningBonusNum, ticket.nums)
            this.result.add(lottoWinner)
        }
    }

    fun pair(winingNums: List<Int>, bonusNum: Int, ticketNums: List<Int>): LottoWinner {
        val countCorrect = ticketNums.count { it in winingNums }
        val countBonus = if (bonusNum in ticketNums) 1 else 0

        return when {
            countCorrect == 6 -> LottoWinner.FIRST_PLACE
            countCorrect == 5 && countBonus == 1 -> LottoWinner.SECOND_PLACE
            countCorrect == 5 -> LottoWinner.THIRD_PLACE
            countCorrect == 4 -> LottoWinner.FOURTH_PLACE
            countCorrect == 3 -> LottoWinner.FIFTH_PLACE
            else -> LottoWinner.NONE
        }
    }
}