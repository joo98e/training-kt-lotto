package domain.cash

import common.exception.ExpectedException
import domain.cash.exception.CashOverConsumptionException
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

    @Test
    fun `일부 소비, 사용한 금액만큼 금액은 차감되고, usedCash 가 올라간다`() {
        val case = 100_000
        val cash = Cash(case)
        val willUseCash = 99_999
        val restCash = 1

        cash.use(willUseCash)

        cash.amount shouldBe restCash
        cash.usedAmount shouldBe willUseCash
    }

    @Test
    fun `전액 소비, 사용한 금액만큼 금액은 차감되고, usedCash 가 올라간다`() {
        val case = 100_000
        val cash = Cash(case)
        val willUseCash = 100_000
        val restCash = case - willUseCash

        cash.use(willUseCash)

        cash.amount shouldBe restCash
        cash.usedAmount shouldBe willUseCash
    }

    @Test
    fun `초과 소비, Exception 을 던진다`() {
        val case = 100_000
        val cash = Cash(case)
        val willUseCash = 100_001

        val shouldThrow = shouldThrow<CashOverConsumptionException> {
            cash.use(willUseCash)
        }

        shouldThrow.message shouldBe "[ERROR]: 잔액보다 사용 금액이 높습니다."
    }
}