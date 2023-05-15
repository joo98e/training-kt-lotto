package domain.lotto.machine.manual

import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.ball.LottoBonusBall
import domain.lotto.constants.LottoConstant
import domain.lotto.machine.enums.LottoTicketingMode
import domain.lotto.ticket.LottoTicket
import view.collector.ReadlineCollector

object LottoManualMachine : LottoManualMachineInterface {
    override fun execute(lottoBallBundle: LottoBallBundle): LottoTicket {
        val bonusBall = LottoBonusBall(
            LottoBall(LottoConstant.LOTTO_NUM_RANGE.shuffled()
                .first { it !in lottoBallBundle.getBallNums() })
        )

        return LottoTicket(LottoTicketingMode.MANUAL, lottoBallBundle, bonusBall)
    }

    override fun getLottoBalls(): List<LottoBall> {
        println("로또 번호를 입력해 주세요.")
        return ReadlineCollector.getListInt().map { LottoBall(it) }
    }
}