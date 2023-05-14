package view

import common.exception.ExpectedException
import common.validation.Validation
import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.validation.LottoValidation

object InputView {
    fun getPurchaseLottoAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val amount = readln()

        if (Validation.isNotNumeric(amount)) throw ExpectedException("구입 금액은 숫자여야 합니다.")
        return amount.toInt()
    }

    fun getLottoManualBalls(): LottoBallBundle {
        val tempBallNums = mutableListOf<Int>()

        while (tempBallNums.size < 6) {
            print("번호를 입력하세요.")
            val inputBallNum = readln().trim()

            if (Validation.isNotNumeric(inputBallNum)) println("번호는 숫자 형식이어야 합니다. 다시 입력해 주세요.")
            val lottoNums = inputBallNum.toInt()
            if (LottoValidation.isNotRangeForWinningNum(lottoNums)) throw ExpectedException("로또 번호는 1 ~ 45 사이어야 합니다.")

            tempBallNums.add(lottoNums)
        }

        return LottoBallBundle(List(tempBallNums.size) { LottoBall(it) })
    }

    fun getResultLottoBallNums(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun getBonusNumber(): String {
        println("지난 주 보너스 번호를 입력해 주세요.")
        return readln()
    }
}