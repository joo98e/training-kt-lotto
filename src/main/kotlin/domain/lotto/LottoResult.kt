package domain.lotto

import common.exception.ExpectedException
import common.util.StringUtil
import common.validation.Validation
import constants.lotto.LottoConstant
import enums.LottoWinner

class LottoResult(
    private val lottoTickets: List<LottoTicket>,
    private val inputWinningNums: String,
    private val inputBonusNum: String
) {
    private var result: MutableList<LottoWinner> = mutableListOf()
    private var winningNums: List<Int> = listOf()
    private var bonusNum: Int? = null

    init {
        val stringList = StringUtil.split(this.inputWinningNums, ",")

        if (stringList.any { Validation.isNonPositiveNumeric(it) }) {
            throw ExpectedException("모든 숫자를 양수로 입력해 주세요.")
        }

        val tempWinningNums = stringList.map { it.toInt() }

        if (Validation.hasDuplicateNumbers(tempWinningNums)) {
            throw ExpectedException("중복된 숫자가 있습니다.")
        }

        if (tempWinningNums.any { it == 0 }) {
            throw ExpectedException("당첨 번호는 1 이상 45 이하의 숫자여야 합니다.")
        }

        if (LottoValidation.isNotRangeForWinningNums(tempWinningNums)) {
            throw ExpectedException("당첨 번호는 1 이상 45 이하의 숫자여야 합니다.")
        }

        if (Validation.isNotNumeric(this.inputBonusNum)) {
            throw ExpectedException("보너스 번호는 숫자여야 합니다.")
        }

        this.winningNums = tempWinningNums
        this.bonusNum = inputBonusNum.toInt()

        if (this.winningNums.size != LottoConstant.LOTTO_NUM_LENGTH) {
            throw ExpectedException("당첨 번호의 size 는 6이어야 합니다.")
        }

        if (this.bonusNum in this.winningNums) {
            throw ExpectedException("당첨 번호에 보너스 번호가 포함될 수 없습니다.")
        }



        initializeCalculateLotto()
    }

    private fun initializeCalculateLotto() {
        lottoTickets.forEach { ticket ->
            val lottoWinner = pair(this.winningNums, this.bonusNum!!, ticket.nums)
            this.result.add(lottoWinner)
        }
    }

    fun getResult(): MutableList<LottoWinner> {
        return this.result
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