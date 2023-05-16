package domain.lotto.machine.manual

import domain.lotto.ball.LottoBall
import domain.lotto.machine.LottoManualMachine
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoManualMachineTest {
    private lateinit var lottoBalls: List<LottoBall>

    @BeforeEach
    fun setUp() {
        lottoBalls = listOf(
            LottoBall(1),
            LottoBall(2),
            LottoBall(3),
            LottoBall(4),
            LottoBall(5),
            LottoBall(6),
        )
    }

    @Test
    fun `execute 로 반환된 LottoTicket 의 bonusBallNum 은 파라미터의 로또 번호와 겹치지 않는다`() {
        val lottoBallsToIntList = lottoBalls.map { it.num }
        val execute = LottoManualMachine.execute()
        val shouldBeTruthy = execute.bonusBall.ball.num !in lottoBallsToIntList

        shouldBeTruthy shouldBe true
    }

}