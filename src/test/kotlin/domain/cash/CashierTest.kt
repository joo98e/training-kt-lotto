package domain.cash

import domain.cashier.Cashier
import domain.gambler.Gambler
import domain.lotto.machine.enums.LottoTicketingMode
import domain.lotto.ticket.LottoTicketBundle
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CashierTest {
    @Test
    fun `전부 자동 구매 Cashier 는 전달 받은 내용의 로또를 구매해서 Gambler 를 modify 해준다`() {
        val gambler = Gambler(Cash(10000))
        Cashier.purchaseLottoTickets(LottoTicketingMode.AUTO, gambler, 10)

        val isTruthy = gambler.ticketBundle.tickets.all { ticket -> ticket.mode === LottoTicketingMode.AUTO }

        isTruthy shouldBe true
    }

    @Test
    fun `Cashier 는 로또 티켓의 개수를 받으면 총 구매 가격을 리턴한다`() {
        val lottoPurchasePrice = Cashier.getLottoPurchasePrice(5)
        lottoPurchasePrice shouldBe 5000
    }

    @Test
    fun `Cashier 는 Gambler 를 전달 받아, 파라미터만큼 수정해준다`() {
        val initializeCash = 10000
        val willUseCash = 2000
        val cash = Cash(initializeCash)
        val restCash = initializeCash - willUseCash

        val lottoTicketBundle = LottoTicketBundle(mutableListOf())
        val gambler = Gambler(cash, lottoTicketBundle)
        Cashier.adjustmentToLottoGambler(gambler, willUseCash, listOf())

        gambler.cash.amount shouldBe restCash
        gambler.cash.usedAmount shouldBe willUseCash
    }
}