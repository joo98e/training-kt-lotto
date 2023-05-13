package domain.gambler

import domain.cash.Cash
import domain.lotto.ticket.LottoTicketBundle

class Gambler(
    val cash: Cash,
    private val tickets: LottoTicketBundle
) {

    fun getTickets(): LottoTicketBundle {
        return this.tickets
    }

}