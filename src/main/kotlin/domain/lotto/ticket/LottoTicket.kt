package domain.lotto.ticket

import common.exception.ExpectedException
import domain.lotto.ball.LottoBallBundle
import domain.lotto.ball.LottoBonusBall
import domain.lotto.machine.enums.LottoTicketingMode


class LottoTicket(
    val mode: LottoTicketingMode,
    val lottoBallBundle: LottoBallBundle,
    val bonusBall: LottoBonusBall
) {
    init {
        if (bonusBall.ball.num in lottoBallBundle.getBallNums()) {
            throw ExpectedException("당첨 번호에 보너스 번호가 포함될 수 없습니다.")
        }
    }
}