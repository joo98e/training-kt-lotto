package domain.lotto.result

import common.exception.ExpectedException
import domain.lotto.ticket.LottoTicketBundle
import domain.lotto.enums.LottoWonLotteryEnum
import domain.lotto.machine.LottoLotteryResultMachine

class LottoResult(
    private val lottoBundle: LottoTicketBundle,
    private val resultBallBundle: LottoResultBallBundle,
    private val resultBonusBall: LottoResultBonusBall
) {
    private var wonLotteries: MutableList<LottoWonLotteryEnum> = mutableListOf()

    init {
        if (resultBonusBall.lottoBall.num in resultBallBundle.lottoBallBundle.getBallNums()) {
            throw ExpectedException("당첨 번호에 보너스 번호가 포함될 수 없습니다.")
        }

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

    fun getWonLotteries(): MutableList<LottoWonLotteryEnum> {
        return this.wonLotteries
    }


}