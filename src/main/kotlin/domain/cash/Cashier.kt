package domain.cash

import domain.cash.exception.CashierMoneyException
import domain.gambler.Gambler
import domain.lotto.machine.auto.LottoAutoMachine
import domain.lotto.machine.manual.LottoManualMachine
import domain.lotto.ticket.LottoTicket
import domain.lotto.ticket.LottoTicketBundle

object Cashier {
    const val PRICE_LOTTO: Int = 1000

    fun purchaseLotto(cash: Cash): Gambler {
        val tickets = getLottoTicketBundle(cash)
        return Gambler(cash, tickets)
    }

    private fun getLottoTicketBundle(cash: Cash): LottoTicketBundle {
        val result = mutableListOf<LottoTicket>()

        if (cash.amount % PRICE_LOTTO > 0) throw CashierMoneyException("금액은 천원 단위로 사용 가능합니다.")

        val ticketsCount = cash.amount / PRICE_LOTTO

        return LottoTicketBundle(List(ticketsCount) { LottoAutoMachine.execute() })
    }

    private fun executeAutoMachine(): LottoTicket {
        return LottoAutoMachine.execute()
    }

    private fun executeManualMachine(): LottoTicket {
        return LottoManualMachine.execute()
    }
}

