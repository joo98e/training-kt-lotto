package domain.lotto.machine.auto

import domain.lotto.ball.LottoBall
import domain.lotto.machine.base.LottoBaseMachineInterface

interface LottoAutoMachineInterface : LottoBaseMachineInterface {
    fun generateLottoBalls(): List<LottoBall>
}