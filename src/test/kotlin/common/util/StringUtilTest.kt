package common.util

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class StringUtilTest {
    @Test
    fun `콤마 분리 테스트`() {
        val str = "1,2,3,4,5,6,7"
        val stringList = StringUtil.split(str, ",")

        val expectedList = listOf(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
        )
        stringList shouldBe expectedList
        stringList.size shouldBe expectedList.size
    }

    @Test
    fun `콤마가 있어도, 문자가 없으면 취급하지 않음`() {
        val str = ".,,23,3,,"
        val stringList = StringUtil.split(str, ",")
        val expectationSize = 3
        stringList.size shouldBe expectationSize
        stringList[0] shouldBe "."
        stringList[1] shouldBe "23"
        stringList[2] shouldBe "3"
    }

    @Test
    fun `공백을 제거 한 뒤 split 한다`() {
        val str = "1,          4, 7"
        val expectationResult = listOf<String>(
            "1",
            "4",
            "7"
        )

        val stringList = StringUtil.split(str, ",")
        stringList.size shouldBe expectationResult.size
        stringList shouldBe expectationResult
    }
}