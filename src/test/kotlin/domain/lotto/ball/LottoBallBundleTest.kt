package domain.lotto.ball

import common.exception.ExpectedException
import common.validation.Validation
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoBallBundleTest {
    @Test
    fun `BallBundle 에 중복된 숫자가 있는지 확인`() {
        val balls: List<LottoBall> = listOf(
            LottoBall(1),
            LottoBall(2),
            LottoBall(3),
            LottoBall(4),
            LottoBall(5),
            LottoBall(6),
        )

        val isNotDuplicateNum = Validation.hasDuplicateNumbers(balls.map { ball -> ball.num })
        isNotDuplicateNum.shouldBeFalse()
    }

    @Test
    fun `BallBundle 의 길이는 LottoConstant LOTTO_NUM_LENGTH 이어야 한다`() {

        shouldThrow<ExpectedException> {
            LottoBallBundle(
                listOf(
                    LottoBall(1),
                    LottoBall(2),
                    LottoBall(3),
                    LottoBall(4),
                    LottoBall(5),
                    LottoBall(6),
                    LottoBall(7),
                )
            )
        }.message shouldBe "[ERROR]: 로또 티켓의 번호는 총 6개의 숫자만을 가져야 합니다."
    }
}