package domain.lotto.ball

import common.exception.ExpectedException
import common.validation.Validation

open class LottoBallBundle(private val lottoBalls: List<LottoBall>) {

    init {
        if (lottoBalls.size != LOTTO_LENGTH) {
            throw ExpectedException("로또 티켓의 번호는 총 6개의 숫자만을 가져야 합니다.")
        }

        val ballNums = getBallNums()
        if (Validation.hasDuplicateNumbers(ballNums)) {
            throw ExpectedException("로또 티켓의 번호에 중복된 숫자가 있습니다.")
        }
    }

    fun getBallNums(): List<Int> {
        return this.lottoBalls.map { it.num }
    }

    companion object {
        const val LOTTO_LENGTH = 6
    }
}