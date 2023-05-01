package domain.cash

import common.exception.ExpectedException
import domain.gambler.Gambler
import domain.lotto.LottoTicket

object Cashier {
    const val PRICE_LOTTO: Int = 1000

    fun purchase(amount: Int): Gambler {
        val tickets = getLottoTickets(amount)
        return Gambler(amount, tickets)
    }

    private fun getLottoTickets(amount: Int): List<LottoTicket> {
        if (amount % PRICE_LOTTO > 0) throw ExpectedException("금액은 천원 단위로 사용 가능합니다.");
        val ticketsCount = amount / PRICE_LOTTO
        return List(ticketsCount) { LottoTicket() }
    }
}

