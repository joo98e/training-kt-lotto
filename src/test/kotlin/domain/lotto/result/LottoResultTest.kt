package domain.lotto.result

import common.exception.ExpectedException
import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.ball.LottoBonusBall
import domain.lotto.enums.LottoWinner
import domain.lotto.machine.LottoMachine
import domain.lotto.ticket.LottoTicket
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
        lottoTickets = LottoTicketBundle(List(10) { LottoMachine.execute() })
    }

    @Test
    fun `지난 주 당첨 번호와 보너스 번호를 받을 때 겹치는 번호가 있는지 확인한다`() {
        val lottoBalls = listOf(
            LottoBall("1"),
            LottoBall("2"),
            LottoBall("3"),
            LottoBall("4"),
            LottoBall("5"),
            LottoBall("6"),
        )

        val exception = shouldThrow<ExpectedException> {
            LottoResult(
                lottoTickets, LottoResultBallBundle(
                    lottoBalls
                ), LottoResultBonusBall("6")
            )
        }

        exception.message shouldBe "[ERROR]: 당첨 번호에 보너스 번호가 포함될 수 없습니다."
    }

    @Test
    fun `당첨 번호의 길이가 모자랄 경우 (6이어야 함)`() {
        val exception = shouldThrow<ExpectedException> {
            LottoResult(
                lottoTickets, LottoResultBallBundle(
                    listOf(
                        LottoBall("1"),
                        LottoBall("2"),
                        LottoBall("3"),
                        LottoBall("4"),
                        LottoBall("5"),
                    )
                ), LottoResultBonusBall("6")
            )
        }

        exception.message shouldBe "[ERROR]: 로또 티켓의 번호는 총 6개의 숫자만을 가져야 합니다."
    }

    @Test
    fun `당첨 번호의 길이가 알맞음`() {
        shouldNotThrow<ExpectedException> {
            LottoResult(
                lottoTickets, LottoResultBallBundle(
                    listOf(
                        LottoBall("1"),
                        LottoBall("2"),
                        LottoBall("3"),
                        LottoBall("4"),
                        LottoBall("5"),
                        LottoBall("6"),
                    )
                ), LottoResultBonusBall("7")
            )
        }
    }

    @Test
    fun `당첨 번호의 길이가 넘을 경우 (6이어야 함)`() {
        val exception = shouldThrow<ExpectedException> {
            LottoResult(
                lottoTickets, LottoResultBallBundle(
                    listOf(
                        LottoBall("1"),
                        LottoBall("2"),
                        LottoBall("3"),
                        LottoBall("4"),
                        LottoBall("5"),
                        LottoBall("6"),
                        LottoBall("7"),
                    )
                ), LottoResultBonusBall("8")
            )
        }

        exception.message shouldBe "[ERROR]: 로또 티켓의 번호는 총 6개의 숫자만을 가져야 합니다."
    }


    @Test
    fun `당첨 테스트 - 1등(6개 모두 일치)`() {
        val lottoResult = LottoResult(
            lottoTickets, LottoResultBallBundle(
                listOf(
                    LottoBall("1"),
                    LottoBall("2"),
                    LottoBall("3"),
                    LottoBall("4"),
                    LottoBall("5"),
                    LottoBall("6"),
                )
            ), LottoResultBonusBall("8")
        )

        val pair = lottoResult.pair(
            LottoResultBallBundle(
                listOf(
                    LottoBall("1"),
                    LottoBall("2"),
                    LottoBall("3"),
                    LottoBall("4"),
                    LottoBall("5"),
                    LottoBall("6"),
                )
            ), LottoResultBonusBall("8"), LottoTicket(
                LottoBallBundle(
                    listOf(
                        LottoBall("1"),
                        LottoBall("2"),
                        LottoBall("3"),
                        LottoBall("4"),
                        LottoBall("5"),
                        LottoBall("6"),
                    )
                ), LottoBonusBall("7")
            )
        )
        pair shouldBe LottoWinner.FIRST_PLACE
    }

    @Test
    fun `당첨 테스트 - 2등(1개 빼고 일치 + 보너스 번호 일치)`() {
        val lottoResult = LottoResult(
            lottoTickets, LottoResultBallBundle(
                listOf(
                    LottoBall("1"),
                    LottoBall("2"),
                    LottoBall("3"),
                    LottoBall("4"),
                    LottoBall("5"),
                    LottoBall("6"),
                )
            ), LottoResultBonusBall("7")
        )

        val pair = lottoResult.pair(
            LottoResultBallBundle(
                listOf(
                    LottoBall("1"),
                    LottoBall("2"),
                    LottoBall("3"),
                    LottoBall("4"),
                    LottoBall("5"),
                    LottoBall("6"),
                )
            ), LottoResultBonusBall("7"), LottoTicket(
                LottoBallBundle(
                    listOf(
                        LottoBall("1"),
                        LottoBall("2"),
                        LottoBall("3"),
                        LottoBall("4"),
                        LottoBall("5"),
                        LottoBall("45"),
                    )
                ), LottoBonusBall("7")
            )
        )

        pair shouldBe LottoWinner.SECOND_PLACE
    }

    @Test
    fun `당첨 테스트 - 3등(5개 일치)`() {
        val lottoResult = LottoResult(
            lottoTickets, LottoResultBallBundle(
                listOf(
                    LottoBall("1"),
                    LottoBall("2"),
                    LottoBall("3"),
                    LottoBall("4"),
                    LottoBall("5"),
                    LottoBall("7"),
                )
            ), LottoResultBonusBall("8")
        )

        val pair = lottoResult.pair(
            LottoResultBallBundle(
                listOf(
                    LottoBall("1"),
                    LottoBall("2"),
                    LottoBall("3"),
                    LottoBall("4"),
                    LottoBall("5"),
                    LottoBall("6"),
                )
            ), LottoResultBonusBall("7"), LottoTicket(
                LottoBallBundle(
                    listOf(
                        LottoBall("1"),
                        LottoBall("2"),
                        LottoBall("3"),
                        LottoBall("4"),
                        LottoBall("5"),
                        LottoBall("45"),
                    )
                ), LottoBonusBall("44")
            )
        )

        pair shouldBe LottoWinner.THIRD_PLACE
    }

    @Test
    fun `당첨 테스트 - 4등(4개 일치)`() {
        val lottoResult = LottoResult(
            lottoTickets, LottoResultBallBundle(
                listOf(
                    LottoBall("1"),
                    LottoBall("2"),
                    LottoBall("3"),
                    LottoBall("4"),
                    LottoBall("5"),
                    LottoBall("6"),
                )
            ), LottoResultBonusBall("7")
        )

        val pair = lottoResult.pair(
            LottoResultBallBundle(
                listOf(
                    LottoBall("1"),
                    LottoBall("2"),
                    LottoBall("3"),
                    LottoBall("4"),
                    LottoBall("5"),
                    LottoBall("6"),
                )
            ), LottoResultBonusBall("7"), LottoTicket(
                LottoBallBundle(
                    listOf(
                        LottoBall("1"),
                        LottoBall("2"),
                        LottoBall("3"),
                        LottoBall("4"),
                        LottoBall("43"),
                        LottoBall("44"),
                    )
                ), LottoBonusBall("45")
            )
        )
        pair shouldBe LottoWinner.FOURTH_PLACE
    }

    @Test
    fun `당첨 테스트 - 5등(3개 일치)`() {
        val lottoResult = LottoResult(
            lottoTickets, LottoResultBallBundle(
                listOf(
                    LottoBall("1"),
                    LottoBall("2"),
                    LottoBall("3"),
                    LottoBall("4"),
                    LottoBall("5"),
                    LottoBall("6"),
                )
            ), LottoResultBonusBall("7")
        )

        val pair = lottoResult.pair(
            LottoResultBallBundle(
                listOf(
                    LottoBall("1"),
                    LottoBall("2"),
                    LottoBall("3"),
                    LottoBall("4"),
                    LottoBall("5"),
                    LottoBall("6"),
                )
            ), LottoResultBonusBall("7"), LottoTicket(
                LottoBallBundle(
                    listOf(
                        LottoBall("1"),
                        LottoBall("2"),
                        LottoBall("3"),
                        LottoBall("42"),
                        LottoBall("43"),
                        LottoBall("44"),
                    )
                ), LottoBonusBall("45")
            )
        )
        pair shouldBe LottoWinner.FIFTH_PLACE
    }
}