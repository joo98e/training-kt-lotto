package domain.cash

import common.exception.ExpectedException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CashTest {
    @Test
    fun `Cash 의 생성자에 전달되는 인수는 숫자이다`() {
        val case1 = 14000
        val case2 = 14_000
        val cash1 = Cash(case1)
        val cash2 = Cash(case2)

        cash1.amount shouldBe case1
        cash2.amount shouldBe case2
    }

    @Test
    fun `Cash 에는 음의 정수가 들어올 수 없다`() {
        val case1 = -14000
        val case3 = -14000

        val shouldThrowCase1 = shouldThrow<ExpectedException> {
            Cash(case1)
        }
        shouldThrowCase1.message shouldBe "[ERROR]: 금액은 양의 정수여야 합니다."

        val shouldThrowCase3 = shouldThrow<ExpectedException> {
            Cash(case3)
        }
        shouldThrowCase3.message shouldBe "[ERROR]: 금액은 양의 정수여야 합니다."
    }
}