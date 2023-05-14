package domain.lotto.machine.manual

import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.ball.LottoBonusBall
import domain.lotto.constants.LottoConstant
import domain.lotto.machine.enums.LottoTicketingMode
import domain.lotto.ticket.LottoTicket

object LottoManualMachine : LottoManualMachineInterface {
    override fun execute(): LottoTicket {
        val lottoBalls = List(listOf(1, 2, 3, 4, 5, 6).size) { LottoBall(it) }

        val lottoBallBundle = LottoBallBundle(lottoBalls)
        val bonusBall =
            LottoBonusBall(
                LottoBall(
                    LottoConstant.LOTTO_NUM_RANGE.shuffled().first { it !in lottoBallBundle.getBallNums() }
                ))

        return LottoTicket(LottoTicketingMode.MANUAL, lottoBallBundle, bonusBall)
    }
}