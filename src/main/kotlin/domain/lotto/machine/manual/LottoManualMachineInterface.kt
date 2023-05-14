package domain.lotto.machine.manual

import domain.lotto.machine.base.LottoBaseMachineInterface
import domain.lotto.ticket.LottoTicket

interface LottoManualMachineInterface : LottoBaseMachineInterface {
    fun execute(ballNums: List<Int>): LottoTicket
}