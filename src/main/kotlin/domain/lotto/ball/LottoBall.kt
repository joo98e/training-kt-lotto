package domain.lotto.ball

import common.exception.ExpectedException
import common.validation.Validation
import domain.lotto.validation.LottoValidation

class LottoBall(ballNum: String) {
    val num: Int

    init {
        if (Validation.isNotNumeric(ballNum)) {
            throw ExpectedException("로또의 볼 번호는 숫자여야 합니다. (입력된 값: $ballNum)")
        }

        if (LottoValidation.isNotRangeForWinningNum(ballNum.toInt())) {
            throw ExpectedException("로또의 볼 번호는 1 이상 45 이하이어야 합니다. (현재 값: $ballNum)")
        }

        this.num = ballNum.toInt()
    }
}