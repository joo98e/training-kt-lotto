package domain.lotto.machine.base

import domain.lotto.ticket.LottoTicket

interface LottoBaseMachineInterface {
    fun execute(): LottoTicket
}