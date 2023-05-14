package domain.lotto.ticket

import domain.lotto.ball.LottoBallBundle
import domain.lotto.ball.LottoBonusBall
import domain.lotto.machine.enums.LottoTicketingMode


class LottoTicket(
    val mode: LottoTicketingMode,
    val lottoBallBundle: LottoBallBundle,
    val bonusBall: LottoBonusBall
) {}