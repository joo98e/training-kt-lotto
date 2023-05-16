package domain.lotto.machine

import domain.lotto.ticket.LottoTicket

interface LottoMachine {
    fun execute(): LottoTicket
}