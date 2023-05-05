package domain.lotto.result

import domain.lotto.ticket.LottoTicketBundle
import domain.lotto.enums.LottoWinner
import domain.lotto.ticket.LottoTicket

class LottoResult(
    private val lottoBundle: LottoTicketBundle,
    private val resultBallBundle: LottoResultBallBundle,
    private val resultBonusBall: LottoResultBonusBall
) {
    private var result: MutableList<LottoWinner> = mutableListOf()

    init {
        initializeCalculateLotto()
    }

    private fun initializeCalculateLotto() {
        lottoBundle.tickets.forEach { ticket ->
            val lottoWinner = pair(
                this.resultBallBundle,
                this.resultBonusBall,
                ticket
            )

            this.result.add(lottoWinner)
        }
    }

    fun getResult(): MutableList<LottoWinner> {
        return this.result
    }

    fun pair(
        lottoResultBallBundle: LottoResultBallBundle,
        lottoResultBonusBall: LottoResultBonusBall,
        lottoTicket: LottoTicket
    ): LottoWinner {
        val ticketBallNums =
            lottoTicket.lottoBallBundle.getBallNums().count { it in lottoResultBallBundle.getBallNums() }
        val countBonus = if (lottoResultBonusBall.num in lottoTicket.lottoBallBundle.getBallNums()) 1 else 0

        return when {
            ticketBallNums == 6 -> LottoWinner.FIRST_PLACE
            ticketBallNums == 5 && countBonus == 1 -> LottoWinner.SECOND_PLACE
            ticketBallNums == 5 -> LottoWinner.THIRD_PLACE
            ticketBallNums == 4 -> LottoWinner.FOURTH_PLACE
            ticketBallNums == 3 -> LottoWinner.FIFTH_PLACE
            else -> LottoWinner.NONE
        }
    }
}