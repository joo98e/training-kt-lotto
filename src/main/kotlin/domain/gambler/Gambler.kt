package domain.gambler

import domain.cash.Cash
import domain.lotto.ticket.LottoTicketBundle

class Gambler(
    private val cash: Cash,
    private val tickets: LottoTicketBundle
) {

    fun getTickets(): LottoTicketBundle {
        return this.tickets
    }

    fun getCash(): Cash {
        return this.cash
    }
}