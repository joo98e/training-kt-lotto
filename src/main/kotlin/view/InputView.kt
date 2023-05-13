package view

import common.exception.ExpectedException
import common.validation.Validation

object InputView {
    fun getPurchaseLottoAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val amount = readln()

        if (Validation.isNotNumeric(amount)) throw ExpectedException("구입 금액은 숫자여야 합니다.")
        return amount.toInt()
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