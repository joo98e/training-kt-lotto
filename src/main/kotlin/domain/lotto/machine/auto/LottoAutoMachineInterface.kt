package domain.lotto.machine.auto

import domain.lotto.ball.LottoBall
import domain.lotto.machine.base.LottoBaseMachineInterface
import domain.lotto.ticket.LottoTicket

interface LottoAutoMachineInterface : LottoBaseMachineInterface {
    fun generateLottoBalls(): List<LottoBall>
    fun execute(): LottoTicket
}