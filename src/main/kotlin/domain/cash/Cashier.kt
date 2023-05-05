package domain.cash

import common.exception.ExpectedException
import domain.gambler.Gambler
import domain.lotto.machine.LottoMachine
import domain.lotto.ticket.LottoTicketBundle

object Cashier {
    const val PRICE_LOTTO: Int = 1000

    fun purchaseLotto(cash: Cash): Gambler {
        val tickets = getLottoTicketBundle(cash)
        return Gambler(cash, tickets)
    }

    private fun getLottoTicketBundle(cash: Cash): LottoTicketBundle {
        if (cash.amount % PRICE_LOTTO > 0) throw ExpectedException("금액은 천원 단위로 사용 가능합니다.")

        val ticketsCount = cash.amount / PRICE_LOTTO
        return LottoTicketBundle(List(ticketsCount) { LottoMachine.execute() })
    }
}

