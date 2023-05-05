package domain.lotto.machine

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
        val ticketBallNums =
            lottoTicket.lottoBallBundle.getBallNums().count { it in lottoResultBallBundle.getBallNums() }
        val countBonus = if (lottoResultBonusBall.num == lottoTicket.bonusBall.num) 1 else 0

        return when {
            ticketBallNums == 6 -> LottoWonLotteryEnum.FIRST_PLACE
            ticketBallNums == 5 && countBonus == 1 -> LottoWonLotteryEnum.SECOND_PLACE
            ticketBallNums == 5 -> LottoWonLotteryEnum.THIRD_PLACE
            ticketBallNums == 4 -> LottoWonLotteryEnum.FOURTH_PLACE
            ticketBallNums == 3 -> LottoWonLotteryEnum.FIFTH_PLACE
            else -> LottoWonLotteryEnum.NONE
        }
    }
}