package view.collector

import common.exception.ExpectedException
import common.util.StringUtil
import common.validation.Validation
import domain.lotto.ball.LottoBall
import domain.lotto.ball.LottoBallBundle
import domain.lotto.machine.enums.LottoTicketingMode
import domain.lotto.result.LottoResultBallBundle
import domain.lotto.result.LottoResultBonusBall
import view.exception.ReadlineFormatException

object ReadlineCollector {
    fun getPurchaseLottoAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val amount = readln()

        if (Validation.isNotNumeric(amount)) throw ExpectedException("구입 금액은 숫자여야 합니다.")
        return amount.toInt()
    }

    fun getTicketCount(type: LottoTicketingMode): Int {
        println("구입할 ${type.desc} 티켓의 개수를 입력해 주세요.")
        val count = readln()
        if (Validation.isNotNumeric(count)) throw ExpectedException("구입 티켓의 개수는 숫자여야 합니다.")
        return count.toInt()
    }

    fun getResultLottoBallNums(): LottoResultBallBundle {
        println("지난 주 당첨 번호를 콤마로 분리하여 입력해 주세요.")
        val inputValue = readln()

        val ballNums = StringUtil.split(inputValue)
        return LottoResultBallBundle(LottoBallBundle(ballNums.map { LottoBall(it.toInt()) }))
    }

    fun getListInt(): List<Int> {
        val inputValue = readln()

        val intValues = StringUtil.split(inputValue)
        return intValues.map {
            if (Validation.isNotNumeric(it)) throw ReadlineFormatException("숫자 형식이 잘못 되었습니다.")
            it.toInt()
        }
    }

    fun getResultBonusNumber(): LottoResultBonusBall {
        println("지난 주 보너스 번호를 입력해 주세요.")
        val inputValue = readln()

        if (Validation.isNotNumeric(inputValue)) println("번호는 숫자 형식이어야 합니다. 다시 입력해 주세요.")

        return LottoResultBonusBall(LottoBall(inputValue.toInt()))
    }
}