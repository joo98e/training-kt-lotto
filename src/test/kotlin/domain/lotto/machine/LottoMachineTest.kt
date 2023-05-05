package domain.lotto.machine

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `nums 변수와 bonus num 은 서로 겹치지 않아야 한다`() {
        val lottoTicket = LottoMachine.execute()
        val isNotIncludedBonusNum: Boolean = lottoTicket.bonusBall.num !in lottoTicket.lottoBallBundle.getBallNums()
        isNotIncludedBonusNum shouldBe true
    }
}