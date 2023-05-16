package domain.lotto.machine

import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.ball.LottoBonusBall
import domain.lotto.enums.LottoWonLotteryEnum
import domain.lotto.machine.enums.LottoTicketingMode
import domain.lotto.result.LottoLotteryResult
import domain.lotto.result.LottoResultBallBundle
import domain.lotto.result.LottoResultBonusBall
import domain.lotto.ticket.LottoTicket
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoLotteryResultMachineTest {
    @Test
    fun `당첨 테스트 - 1등(6개 모두 일치)`() {

        val lottoWonLotteryEnum = LottoLotteryResult.lottery(
            LottoResultBallBundle(
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
            ), LottoResultBonusBall(LottoBall(8)), LottoTicket(
                LottoTicketingMode.AUTO,
                LottoBallBundle(
                    listOf(
                        LottoBall(1),
                        LottoBall(2),
                        LottoBall(3),
                        LottoBall(4),
                        LottoBall(5),
                        LottoBall(6),
                    )
                ), LottoBonusBall(LottoBall(7))
            )
        )
        lottoWonLotteryEnum shouldBe LottoWonLotteryEnum.FIRST_PLACE
    }

    @Test
    fun `당첨 테스트 - 2등(1개 빼고 일치 + 보너스 번호 일치)`() {
        val lottoWonLotteryEnum = LottoLotteryResult.lottery(
            LottoResultBallBundle(
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
            ), LottoResultBonusBall(LottoBall(7)), LottoTicket(
                LottoTicketingMode.AUTO,
                LottoBallBundle(
                    listOf(
                        LottoBall(1),
                        LottoBall(2),
                        LottoBall(3),
                        LottoBall(4),
                        LottoBall(5),
                        LottoBall(45),
                    )
                ), LottoBonusBall(LottoBall(7))
            )
        )

        lottoWonLotteryEnum shouldBe LottoWonLotteryEnum.SECOND_PLACE
    }

    @Test
    fun `당첨 테스트 - 3등(5개 일치)`() {
        val lottoWonLotteryEnum = LottoLotteryResult.lottery(
            LottoResultBallBundle(
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
            ), LottoResultBonusBall(LottoBall(7)), LottoTicket(
                LottoTicketingMode.AUTO,
                LottoBallBundle(
                    listOf(
                        LottoBall(1),
                        LottoBall(2),
                        LottoBall(3),
                        LottoBall(4),
                        LottoBall(5),
                        LottoBall(45),
                    )
                ), LottoBonusBall(LottoBall(44))
            )
        )

        lottoWonLotteryEnum shouldBe LottoWonLotteryEnum.THIRD_PLACE
    }

    @Test
    fun `당첨 테스트 - 4등(4개 일치)`() {
        val lottoWonLotteryEnum = LottoLotteryResult.lottery(
            LottoResultBallBundle(
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
            ), LottoResultBonusBall(LottoBall(7)), LottoTicket(
                LottoTicketingMode.AUTO,
                LottoBallBundle(
                    listOf(
                        LottoBall(1),
                        LottoBall(2),
                        LottoBall(3),
                        LottoBall(4),
                        LottoBall(43),
                        LottoBall(44),
                    )
                ), LottoBonusBall(LottoBall(45))
            )
        )
        lottoWonLotteryEnum shouldBe LottoWonLotteryEnum.FOURTH_PLACE
    }

    @Test
    fun `당첨 테스트 - 5등(3개 일치)`() {
        val lottoWonLotteryEnum = LottoLotteryResult.lottery(
            LottoResultBallBundle(
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
            ), LottoResultBonusBall(LottoBall(7)), LottoTicket(
                LottoTicketingMode.AUTO,
                LottoBallBundle(
                    listOf(
                        LottoBall(1),
                        LottoBall(2),
                        LottoBall(3),
                        LottoBall(42),
                        LottoBall(43),
                        LottoBall(44),
                    )
                ), LottoBonusBall(LottoBall(45))
            )
        )
        lottoWonLotteryEnum shouldBe LottoWonLotteryEnum.FIFTH_PLACE
    }
}