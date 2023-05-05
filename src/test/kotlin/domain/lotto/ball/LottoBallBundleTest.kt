package domain.lotto.ball

import common.validation.Validation
import io.kotest.matchers.booleans.shouldBeFalse
import org.junit.jupiter.api.Test

class LottoBallBundleTest {
    @Test
    fun `BallBundle 에 중복된 숫자가 있는지 확인`() {
        val balls: List<LottoBall> = listOf(
            LottoBall("1"),
            LottoBall("2"),
            LottoBall("3"),
            LottoBall("4"),
            LottoBall("5"),
            LottoBall("6"),
        )

        val isNotDuplicateNum = Validation.hasDuplicateNumbers(balls.map { ball -> ball.num })
        isNotDuplicateNum.shouldBeFalse()
    }
}