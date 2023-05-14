package domain.lotto.ticket

import common.exception.ExpectedException
import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.ball.LottoBonusBall
import domain.lotto.machine.enums.LottoTicketingMode
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    fun `로또 번호와 보너스 번호는 받을 때 겹치는 번호가 있는지 확인한다`() {
        val shouldThrow = shouldThrow<ExpectedException> {
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
                ), LottoBonusBall(LottoBall(6))
            )
        }

        shouldThrow.message shouldBe "[ERROR]: 당첨 번호에 보너스 번호가 포함될 수 없습니다."
    }

}