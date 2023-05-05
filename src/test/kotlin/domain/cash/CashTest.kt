package domain.cash

import common.exception.ExpectedException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CashTest {
    @Test
    fun `Cash 의 생성자에 전달되는 인수는 숫자 혹은 문자이고, 숫자로 변환이 가능해야 한다`() {
        val case1 = "14000"
        val case2 = 14_000
        val case3 = "14_000"
        val cash1 = Cash(case1)
        val cash2 = Cash(case2)

        cash1.amount shouldBe case1.toInt()
        cash2.amount shouldBe case2
        shouldThrow<ExpectedException> { Cash(case3) }
    }
}