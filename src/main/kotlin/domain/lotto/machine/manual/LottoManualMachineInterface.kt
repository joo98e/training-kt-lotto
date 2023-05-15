package domain.lotto.machine.manual

import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.machine.base.LottoBaseMachineInterface
import domain.lotto.ticket.LottoTicket

interface LottoManualMachineInterface : LottoBaseMachineInterface {
    fun getLottoBalls(): List<LottoBall>
    fun execute(lottoBallBundle: LottoBallBundle): LottoTicket
}