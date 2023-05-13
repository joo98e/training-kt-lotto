package domain.lotto.ball

import common.exception.ExpectedException
import domain.lotto.validation.LottoValidation

class LottoBall(ballNum: Int) {
    val num: Int

    init {

        if (LottoValidation.isNotRangeForWinningNum(ballNum)) {
            throw ExpectedException("로또의 볼 번호는 1 이상 45 이하이어야 합니다. (현재 값: $ballNum)")
        }

        this.num = ballNum
    }
}