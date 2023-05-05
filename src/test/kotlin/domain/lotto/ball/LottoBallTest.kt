package domain.lotto.ball

import common.exception.ExpectedException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoBallTest {
    @Test
    fun `로또 볼은 항상 숫자여야 한다`() {
        val case1 = "3"
        val lottoBall = LottoBall(case1)

        lottoBall.num shouldBe 3
    }

    @Test
    fun `로또 볼은 1 이상 45 이하의 숫자여야 한다`() {
        val case1 = "1"
        val case2 = "0"
        val case3 = "45"
        val case4 = "46"

        val lottoBall = LottoBall(case1)
        lottoBall.num shouldBe 1

        shouldThrow<ExpectedException> {
            LottoBall(case2)
        }.message shouldBe "[ERROR]: 로또의 볼 번호는 1 이상 45 이하이어야 합니다. (현재 값: $case2)"

        val lottoBall2 = LottoBall(case3)
        lottoBall2.num shouldBe 45

        shouldThrow<ExpectedException> {
            LottoBall(case4)
        }.message shouldBe "[ERROR]: 로또의 볼 번호는 1 이상 45 이하이어야 합니다. (현재 값: $case4)"
    }
}