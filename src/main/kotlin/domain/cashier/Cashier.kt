package domain.cashier

import domain.cash.Cash
import domain.cashier.enums.CashierPriceTag
import domain.cashier.exception.CashierMoneyException
import domain.gambler.Gambler
import domain.lotto.machine.auto.LottoAutoMachine
import domain.lotto.machine.manual.LottoManualMachine
import domain.lotto.ticket.LottoTicket
import domain.lotto.ticket.LottoTicketBundle

object Cashier {
    fun purchaseLotto(cash: Cash): Gambler {
        if (cash.amount % CashierPriceTag.LOTTO.price > 0) throw CashierMoneyException("금액은 천원 단위로 사용 가능합니다.")

        val result = mutableListOf<LottoTicket>()

        val tickets = getLottoTicketBundle(cash)
        return Gambler(cash, tickets)
    }

    private fun getLottoTicketBundle(cash: Cash): LottoTicketBundle {


        val ticketsCount = cash.amount / CashierPriceTag.LOTTO.price

        return LottoTicketBundle(List(ticketsCount) { LottoAutoMachine.execute() })
    }

    private fun executeAutoMachine(): LottoTicket {
        return LottoAutoMachine.execute()
    }

    private fun executeManualMachine(ballNums: List<Int>): LottoTicket {
        return LottoManualMachine.execute(ballNums)
    }
}

