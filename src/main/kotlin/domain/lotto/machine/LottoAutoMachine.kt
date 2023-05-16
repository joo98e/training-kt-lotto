package domain.lotto.machine

import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.ball.LottoBonusBall
import domain.lotto.constants.LottoConstant
import domain.lotto.machine.enums.LottoTicketingMode
import domain.lotto.ticket.LottoTicket

object LottoAutoMachine : LottoMachine {
    override fun execute(): LottoTicket {
        val lottoBallBundle = LottoBallBundle(generateLottoBalls())
        val bonusBall =
            LottoBonusBall(
                LottoBall(
                    LottoConstant.LOTTO_NUM_RANGE.shuffled().first { it !in lottoBallBundle.getBallNums() }
                ))

        return LottoTicket(LottoTicketingMode.AUTO, lottoBallBundle, bonusBall)
    }

    private fun generateLottoBalls(): List<LottoBall> {
        return LottoConstant.LOTTO_NUM_RANGE.shuffled().subList(0, LottoBallBundle.LOTTO_LENGTH)
            .map { LottoBall(it) }
    }
}