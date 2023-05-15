package domain.gambler

import domain.cash.Cash
import domain.lotto.ticket.LottoTicketBundle

class Gambler(
    val cash: Cash,
    val ticketBundle: LottoTicketBundle = LottoTicketBundle(mutableListOf())
) {
}