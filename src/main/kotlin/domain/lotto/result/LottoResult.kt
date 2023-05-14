package domain.lotto.result

import domain.lotto.enums.LottoWonLotteryEnum
import domain.lotto.machine.result.LottoLotteryResultMachine
import domain.lotto.ticket.LottoTicketBundle

class LottoResult(
    private val lottoBundle: LottoTicketBundle,
    private val resultBallBundle: LottoResultBallBundle,
    private val resultBonusBall: LottoResultBonusBall
) {
    val wonLotteries: MutableList<LottoWonLotteryEnum> = mutableListOf()

    init {
        lottery()
    }

    private fun lottery() {
        lottoBundle.tickets.forEach { ticket ->
            val lottoWinner = LottoLotteryResultMachine.lottery(
                this.resultBallBundle,
                this.resultBonusBall,
                ticket
            )

            this.wonLotteries.add(lottoWinner)
        }
    }
}