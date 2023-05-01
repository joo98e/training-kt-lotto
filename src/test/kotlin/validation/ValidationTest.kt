package validation

import common.validation.Validation
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ValidationTest {
    @Test
    fun `숫자 확인 테스트`() {
        val case1 = "1" // 일반 String 양수인 정수
        val case2 = "+1" // 특수문자가 포함된 String 정수
        val case3 = "-1" // 일반 String 음수인 정수
        val case4 = "0.1" // 일반 String 양수인 소수
        val case5 = "-0.1" // 일반 String 음수인 소수
        val case6 = "0,1" // 일반 String 특수문자가 들어간 잘못된 소수

        Validation.isNumeric(case1) shouldBe true
        Validation.isNumeric(case2) shouldBe false
        Validation.isNumeric(case3) shouldBe true
        Validation.isNumeric(case4) shouldBe true
        Validation.isNumeric(case5) shouldBe true
        Validation.isNumeric(case6) shouldBe false
    }
}