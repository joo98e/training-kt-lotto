package common.validation

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ValidationTest {
    @Test
    fun `음수인 것을 골라내는 테스트`() {
        val case1 = "1"
        val case2 = "2"
        val case3 = "-1"

        Validation.isNonPositiveNumeric(case1) shouldBe false
        Validation.isNonPositiveNumeric(case2) shouldBe false
        Validation.isNonPositiveNumeric(case3) shouldBe true
    }

    @Test
    fun `중복된 숫자가 있는지 확인하는 테스트`() {
        val notDuplicate = listOf<Int>(
            1, 2, 3, 4, 5,
        )
        val isDuplicate = listOf<Int>(
            1, 2, 3, 4, 4
        )
        Validation.hasDuplicateNumbers(notDuplicate) shouldBe false
        Validation.hasDuplicateNumbers(isDuplicate) shouldBe true
    }
}