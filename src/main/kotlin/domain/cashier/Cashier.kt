package domain.cashier

import domain.cashier.enums.CashierPriceTag
import domain.gambler.Gambler
import domain.lotto.ball.LottoBallBundle
import domain.lotto.machine.auto.LottoAutoMachine
import domain.lotto.machine.manual.LottoManualMachine
import domain.lotto.ticket.LottoTicket

object Cashier {
    fun purchaseAutoLottoTicket(gambler: Gambler, autoLottoTicketCount: Int) {
        val price = getLottoPurchasePrice(autoLottoTicketCount)
        val ticketSize = price / CashierPriceTag.LOTTO.price

        val autoTickets = mutableListOf<LottoTicket>()
        repeat(ticketSize) { autoTickets.add(LottoAutoMachine.execute()) }

        adjustmentToLottoGambler(gambler, price, autoTickets)
    }

    fun purchaseManualLottoTicket(gambler: Gambler, manualLottoBallBundles: List<LottoBallBundle>) {
        val price = getLottoPurchasePrice(manualLottoBallBundles.size)

        val manualTickets = mutableListOf<LottoTicket>()
        manualLottoBallBundles.forEach { bundle ->
            manualTickets.add(LottoManualMachine.execute(bundle))
        }

        adjustmentToLottoGambler(gambler, price, manualTickets)
    }

    fun getLottoPurchasePrice(count: Int): Int {
        return CashierPriceTag.LOTTO.price * count
    }

    fun adjustmentToLottoGambler(gambler: Gambler, price: Int, tickets: List<LottoTicket>) {
        gambler.cash.use(price)
        gambler.ticketBundle.tickets.addAll(tickets)
    }
}

