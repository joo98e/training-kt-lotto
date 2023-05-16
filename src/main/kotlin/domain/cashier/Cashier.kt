package domain.cashier

import domain.cashier.enums.CashierPriceTag
import domain.gambler.Gambler
import domain.lotto.machine.LottoAutoMachine
import domain.lotto.machine.LottoManualMachine
import domain.lotto.machine.enums.LottoTicketingMode
import domain.lotto.ticket.LottoTicket

object Cashier {
    fun purchaseLottoTickets(mode: LottoTicketingMode, gambler: Gambler, count: Int) {
        val tickets = mutableListOf<LottoTicket>()

        repeat(count) {
            when {
                mode === LottoTicketingMode.AUTO -> tickets.add(LottoAutoMachine.execute())
                mode === LottoTicketingMode.MANUAL -> tickets.add(LottoManualMachine.execute())
            }
        }

        gambler.ticketBundle.tickets.addAll(tickets)
        gambler.cash.use(CashierPriceTag.LOTTO.price * count)
    }

    fun getLottoPurchasePrice(count: Int): Int {
        return CashierPriceTag.LOTTO.price * count
    }

    fun adjustmentToLottoGambler(gambler: Gambler, price: Int, tickets: List<LottoTicket>) {
        gambler.cash.use(price)
        gambler.ticketBundle.tickets.addAll(tickets)
    }
}

