package domain.lotto

import constants.lotto.LottoConstant
import io.kotest.matchers.ints.shouldBeBetween
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `nums 변수에는 1부터 45까지의 숫자만 포함되어야 한다`() {
        val lottoTicket = LottoTicket()
        lottoTicket.nums.forEach {
            it.shouldBeBetween(LottoConstant.WINNING_NUM_RANGE.min(), LottoConstant.WINNING_NUM_RANGE.max())
        }
    }

    @Test
    fun `nums 변수와 bonus num 은 서로 겹치지 않아야 한다`() {
        val lottoTicket = LottoTicket()
        val isNotIncludedBonusNum: Boolean = lottoTicket.bonusNum !in lottoTicket.nums
        isNotIncludedBonusNum shouldBe true
    }
}