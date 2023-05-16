package domain.lotto.machine

import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.ball.LottoBonusBall
import domain.lotto.machine.enums.LottoTicketingMode
import domain.lotto.ticket.LottoTicket
import view.collector.ReadlineCollector

object LottoManualMachine : LottoMachine {
    override fun execute(): LottoTicket {
        val lottoBallBundle = LottoBallBundle(getLottoBalls())

        val bonusBall = LottoBonusBall(getLottoBonusBall())

        return LottoTicket(LottoTicketingMode.MANUAL, lottoBallBundle, bonusBall)
    }

    private fun getLottoBalls(): List<LottoBall> {
        println("로또 번호를 입력해 주세요.")
        return ReadlineCollector.getListInt().map { LottoBall(it) }
    }

    private fun getLottoBonusBall(): LottoBall {
        return LottoBall(ReadlineCollector.getInt("로또 보너스 번호를 입력해 주세요."))
    }
}