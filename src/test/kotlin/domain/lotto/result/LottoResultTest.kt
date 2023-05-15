package domain.lotto.result

import common.exception.ExpectedException
import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.machine.auto.LottoAutoMachine
import domain.lotto.ticket.LottoTicketBundle
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoResultTest {
    private lateinit var lottoTickets: LottoTicketBundle

    @BeforeEach
    fun setup() {
        lottoTickets = LottoTicketBundle(MutableList(10) { LottoAutoMachine.execute() })
    }

    @Test
    fun `당첨 번호의 길이가 모자랄 경우`() {
        val exception = shouldThrow<ExpectedException> {
            LottoResult(
                lottoTickets, LottoResultBallBundle(
                    LottoBallBundle(
                        listOf(
                            LottoBall(1),
                            LottoBall(2),
                            LottoBall(3),
                            LottoBall(4),
                            LottoBall(5),
                        )
                    )
                ), LottoResultBonusBall(LottoBall(6))
            )
        }

        exception.message shouldBe "[ERROR]: 로또 번호는 총 6개의 숫자만을 가져야 합니다."
    }

    @Test
    fun `당첨 번호의 길이가 넘을 경우`() {
        val exception = shouldThrow<ExpectedException> {
            LottoResult(
                lottoTickets, LottoResultBallBundle(
                    LottoBallBundle(
                        listOf(
                            LottoBall(1),
                            LottoBall(2),
                            LottoBall(3),
                            LottoBall(4),
                            LottoBall(5),
                            LottoBall(6),
                            LottoBall(7),
                        )
                    )
                ), LottoResultBonusBall(LottoBall(8))
            )
        }

        exception.message shouldBe "[ERROR]: 로또 번호는 총 6개의 숫자만을 가져야 합니다."
    }

    @Test
    fun `당첨 번호의 길이가 알맞음`() {
        shouldNotThrow<ExpectedException> {
            LottoResult(
                lottoTickets, LottoResultBallBundle(
                    LottoBallBundle(
                        listOf(
                            LottoBall(1),
                            LottoBall(2),
                            LottoBall(3),
                            LottoBall(4),
                            LottoBall(5),
                            LottoBall(6),
                        )
                    )
                ), LottoResultBonusBall(LottoBall(7))
            )
        }
    }

}