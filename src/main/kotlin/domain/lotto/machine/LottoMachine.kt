package domain.lotto.machine

import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.ball.LottoBonusBall
import domain.lotto.constants.LottoConstant
import domain.lotto.ticket.LottoTicket

object LottoMachine {
    fun execute(): LottoTicket {
        val lottoBallBundle =
            LottoBallBundle(LottoConstant.WINNING_NUM_RANGE.shuffled().subList(0, LottoConstant.LOTTO_NUM_LENGTH)
                .map { LottoBall(it.toString()) })

        val bonusBall =
            LottoBonusBall(LottoConstant.WINNING_NUM_RANGE.shuffled().first { it !in lottoBallBundle.getBallNums() }
                .toString())

        return LottoTicket(lottoBallBundle, bonusBall)
    }
}