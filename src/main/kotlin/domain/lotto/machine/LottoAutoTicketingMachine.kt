package domain.lotto.machine

import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.ball.LottoBonusBall
import domain.lotto.constants.LottoConstant
import domain.lotto.ticket.LottoTicket

object LottoAutoTicketingMachine {
    private fun generateLottoBalls(): List<LottoBall> {
        return LottoConstant.LOTTO_NUM_RANGE.shuffled().subList(0, LottoBallBundle.bundleLength)
            .map { LottoBall(it.toString()) }
    }

    fun execute(): LottoTicket {
        val lottoBallBundle = LottoBallBundle(generateLottoBalls())
        val bonusBall =
            LottoBonusBall(
                LottoBall(
                    LottoConstant.LOTTO_NUM_RANGE.shuffled().first { it !in lottoBallBundle.getBallNums() }
                        .toString()))

        return LottoTicket(lottoBallBundle, bonusBall)
    }
}