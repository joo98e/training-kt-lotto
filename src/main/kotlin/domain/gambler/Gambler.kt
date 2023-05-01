package domain.gambler

import domain.lotto.LottoTicket

class Gambler(
    private val paidAmount: Int,
    private val tickets: List<LottoTicket>
) {
    fun getTickets(): List<LottoTicket> {
        return this.tickets
    }

    fun getPaidAmount(): Int {
        return this.paidAmount
    }
}