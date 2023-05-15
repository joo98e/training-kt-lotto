package domain.gambler

import domain.cash.Cash
import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.ball.LottoBonusBall
import domain.lotto.machine.enums.LottoTicketingMode
import domain.lotto.ticket.LottoTicket
import domain.lotto.ticket.LottoTicketBundle
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class GamblerTest {

    @Test
    fun `Gambler 가 가지고 있는 Cash 테스트`() {
        val amount = 1000
        val usedAmount = 2000
        val cash = Cash(amount, usedAmount)
        val gambler = Gambler(cash)
        gambler.cash.amount shouldBe amount
        gambler.cash.usedAmount shouldBe usedAmount
    }

    @Test
    fun `Gambler 가 가지고 있는 Ticket 테스트`() {
        val cash = Cash(1000, 2000)
        val tickets = mutableListOf<LottoTicket>()
        tickets.add(
            LottoTicket(
                LottoTicketingMode.AUTO, LottoBallBundle(
                    listOf(
                        LottoBall(1),
                        LottoBall(2),
                        LottoBall(3),
                        LottoBall(4),
                        LottoBall(5),
                        LottoBall(6),
                    )
                ),
                LottoBonusBall(LottoBall(7))
            )
        )

        val gambler = Gambler(cash, LottoTicketBundle(tickets))
        gambler.ticketBundle.tickets.size shouldBe tickets.size
    }
}