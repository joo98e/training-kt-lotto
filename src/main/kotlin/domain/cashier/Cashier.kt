package domain.cashier

import domain.cash.Cash
import domain.cashier.enums.CashierPriceTag
import domain.cashier.exception.CashierMoneyException
import domain.gambler.Gambler
import domain.lotto.machine.auto.LottoAutoMachine
import domain.lotto.machine.manual.LottoManualMachine
import domain.lotto.ticket.LottoTicket
import domain.lotto.ticket.LottoTicketBundle
import view.collector.ReadlineCollector

object Cashier {
    fun purchaseLotto(cash: Cash, manualTicketCount: Int = 0): Gambler {
        if (cash.amount % CashierPriceTag.LOTTO.price > 0) throw CashierMoneyException("금액은 천원 단위로 사용 가능합니다.")

        val totalCount = cash.amount / CashierPriceTag.LOTTO.price
        val tickets = mutableListOf<LottoTicket>()

        val autoTicketCount = totalCount - manualTicketCount
        repeat(autoTicketCount) { tickets.add(executeAutoMachine()) }

        repeat(manualTicketCount) {
            println("로또 번호를 입력해 주세요.")
            val ballNums = ReadlineCollector.getListInt()
            tickets.add(executeManualMachine(ballNums))
        }

        return Gambler(cash, LottoTicketBundle(tickets))
    }

    private fun executeAutoMachine(): LottoTicket {
        return LottoAutoMachine.execute()
    }

    private fun executeManualMachine(ballNums: List<Int>): LottoTicket {
        return LottoManualMachine.execute(ballNums)
    }
}

