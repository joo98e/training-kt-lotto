package domain.lotto.ticket

import domain.lotto.ball.LottoBallBundle
import domain.lotto.ball.LottoBonusBall


class LottoTicket(
    val lottoBallBundle: LottoBallBundle,
    val bonusBall: LottoBonusBall
) {}