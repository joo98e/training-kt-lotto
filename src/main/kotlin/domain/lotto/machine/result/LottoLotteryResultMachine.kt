package domain.lotto.machine.result

import domain.lotto.enums.LottoWonLotteryEnum
import domain.lotto.result.LottoResultBallBundle
import domain.lotto.result.LottoResultBonusBall
import domain.lotto.ticket.LottoTicket

object LottoLotteryResultMachine {
    fun lottery(
        lottoResultBallBundle: LottoResultBallBundle,
        lottoResultBonusBall: LottoResultBonusBall,
        lottoTicket: LottoTicket
    ): LottoWonLotteryEnum {
        val correctCount = lottoTicket.lottoBallBundle.getBallNums()
            .count { it in lottoResultBallBundle.lottoBallBundle.getBallNums() }
        val countBonus = if (lottoResultBonusBall.lottoBall.num == lottoTicket.bonusBall.ball.num) 1 else 0

        return when {
            correctCount == 6 -> LottoWonLotteryEnum.FIRST_PLACE
            correctCount == 5 && countBonus == 1 -> LottoWonLotteryEnum.SECOND_PLACE
            correctCount == 5 -> LottoWonLotteryEnum.THIRD_PLACE
            correctCount == 4 -> LottoWonLotteryEnum.FOURTH_PLACE
            correctCount == 3 -> LottoWonLotteryEnum.FIFTH_PLACE
            else -> LottoWonLotteryEnum.NONE
        }
    }
}